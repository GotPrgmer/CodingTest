import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (0,-1,0,1,0,-1,1,1,-1)
d_c = (0,0,1,0,-1,1,1,-1,-1)
# 벽 set생성


def sol():
    ans = 0
    wall = set()
    visited = set()
    q = deque([(7, 0)])

    board = [list(input()) for _ in range(8)]
    for r in range(8):
        for c in range(8):
            if board[r][c] == "#":
                wall.add((r, c))
    #bfs를 사용
    while q:
        #현재 턴만틈 돌리기
        for _ in range(len(q)):
            r ,c = q.popleft()
            if (r,c) in wall:
                continue

            if r == 0 and c == 7:
                ans = 1
                return ans

            #현재 위치에서 각 방향으로 가서 q에 넣기
            for nt in range(9):
                nt_r = r + d_r[nt]
                nt_c = c + d_c[nt]

                if 0<=nt_r<8 and 0<=nt_c<8 and (nt_r,nt_c) not in visited and (nt_r,nt_c) not in wall:
                    visited.add((nt_r,nt_c))
                    q.append((nt_r,nt_c))
        #다음턴을 위한 준비
        if wall:
            #wall이 없다면? 이대로 쭈루룩
            #wall이 있다면? 방 초기화해서 갔던 곳 또가게 함.
            visited = set()
            nt_wall = set()
            #벽 갱신
            for w in wall:
                if w[0] < 7:
                    nt_wall.add((w[0]+1,w[1]))
            wall = nt_wall
    return ans



print(sol())
