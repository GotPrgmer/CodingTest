# 두 곳을 제외한 모든 곳에 체력을 1씩 감소시키는 죽음의 비
# 죽음의 비가 안내리는 곳은 현재 있는 위치/ 안전지대라는 곳
# 현재 있는 위치에도 곧 비가 내릴 예정이라 발리 이 죽음의 비를 뚫고 안저니대로 이동해야함
# 다행이도 격자에는 죽의 비를 잠시 막아주는 우산 이 K개 존재
# 우산에도 내구도 D가 있음
# 우산에 비를 맞으면 내구도가 1씩 감소
# 내구도가 0이 되는 순간 우산은 사라짐
# 문제에서 주어지는 우산의 내구도는 모두 D로 동일하다.

# 상하좌우로 이동 (만약 격자판을 벗어나면 이동할 수 없음)
# 이동한 곳이 안전지대라면 반복을 종료

# 이동한 곳에 우산이 있다면 우산을 든다. 만약 이동할 때부터
# 우산을 가지고 있다면 가지고 있는 우산을 버리고 새로운 우산으로 바꿈
# 버린 우산은 더 이상 사용할 수 없음

# 죽음의 비를 맞을 때는 우산을 가지고 있다면 우산의 내구도가 1이 감소하고
# 만약 우산을 가지고 있지 않는다면 체력이 1 감소
# 만약 우산 내구도가 0이 되면 들고 있는 우산이 사라짐
# 만약 체력이 0이 되면 죽음
# 아직 체력이 남아있다면 안전지대까지 위 과정을 반복
# 우산은 U 현재 있는 위치 S, 안전지대 E, 빈칸은 .


import sys

from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)

def sol():
    start = find_start()
    # 행, 열, 체력, 우산 내구도, 카운트
    q = deque([(start[0],start[1],H,0,0)])
    visited = [[0]*N for _ in range(N)]

    while q:
        cur_r, cur_c, cur_h, cur_u, cur_cnt = q.popleft()

        # 사방 탐색
        for d in range(4):
            nr = cur_r + d_r[d]
            nc = cur_c + d_c[d]
            # 격자판 내인지 확인
            if 0 <= nr < N and 0 <= nc < N:
                # 안전지대 라면 종료
                if board[nr][nc] == "E":
                    return cur_cnt + 1
                n_h = cur_h
                n_u = cur_u
                # 이동한 곳에 우산이 있다면?
                if board[nr][nc] == "U":
                    # 주어진 우산 내구도로 변경
                    n_u = D
                # 우산이 없다면 지금 우산을 가지고 있는지 체크해서
                # 우산이 지금 없다면 체력이 1 깎임
                if n_u:
                    n_u -= 1
                else:
                    n_h -= 1
                if n_h == 0:
                    continue

                if visited[nr][nc] < n_h:
                    visited[nr][nc] = n_h
                    q.append((nr,nc,n_h,n_u,cur_cnt+1))

    return -1

def find_start():
    for r in range(N):
        for c in range(N):
            if board[r][c] == "S":
                start = (r,c)
                return start

N, H, D = map(int,input().split())

board = [list(input()) for _ in range(N)]
print(sol())
#S에서 출발
# 안전지대로 이동할 때 최소의 이동 횟수를 출력
# bfs
