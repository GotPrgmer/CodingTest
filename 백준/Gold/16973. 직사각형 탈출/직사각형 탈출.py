# 검사를 어떻게 할 것인가...
# 각 영역의 모든 검사를 다 하면 무조건 시간초과날테고
# 전진하는 면의 부분만 체크하는것도 안될거같고
# 1의 위치를 기록

# 움직이는 방향의 변을 체크해서 이상이 없으면 가는걸로
# 이러면 맨 상단 좌측에 있는 기준점을 두고 검사할 좌표를 계속 계산해야함


import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()


N, M = map(int,input().split())
#입력 받기
square = [list(map(int,input().split())) for _ in range(N)]

H, W, Sr, Sc, Fr, Fc = map(int,input().split())

d_r_check = (-1, 0, H, 0)
d_c_check = (0, W, 0, -1)

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)

# 움직이려는 변을 검사하는 함수
def move_check(r,c,d):
    #각 기준점에서 나아가려는 방향의 변을 좌표로 구하기
    # print('r,c',r,c)
    #상
    #해당 좌표 구하고 오른쪽으로 W-1만큼 전진해야함
    if d == 0:
        fix_r = r + d_r_check[d]
        fix_c = c + d_c_check[d]
        for mv in range(0,W):
            n_c = fix_c + mv
            if 0<= fix_r < N and 0 <= n_c < M:
                # print(fix_r,n_c)

                #1 확인
                if square[fix_r][n_c] == 1:
                    return False
            else:
                return False
        else:
            return True

    #하
    # 해당 좌표 구하고 오른쪽으로 W-1만큼 전진해야함
    if d == 2:
        fix_r = r + d_r_check[d]
        fix_c = c + d_c_check[d]
        for mv in range(0,W):
            n_c = fix_c + mv
            if 0<= fix_r < N and 0 <= n_c < M:
                # print(fix_r,n_c)
                #1 확인
                if square[fix_r][n_c] == 1:
                    return False
            else:
                return False
        else:
            return True

    #좌
    # 해당 좌표 구하고 아래쪽으로 H-1만큼 전진해야함
    if d == 3:
        fix_r = r + d_r_check[d]
        fix_c = c + d_c_check[d]
        for mv in range(0,H):
            n_r = fix_r + mv
            if 0<= n_r < N and 0 <= fix_c < M:
                # print(n_r,fix_c)

                #1 확인
                if square[n_r][fix_c] == 1:
                    return False
            else:
                return False
        else:
            return True

    #우
    # 해당 좌표를 구하고 아래쪽으로 H-1만큼 전진해야함
    if d == 1:
        fix_r = r + d_r_check[d]
        fix_c = c + d_c_check[d]
        for mv in range(0,H):
            n_r = fix_r + mv
            if 0<= n_r < N and 0 <= fix_c < M:
                # print(n_r,fix_c)

                #1 확인
                if square[n_r][fix_c] == 1:
                    return False
            else:
                return False
        else:
            return True

def bfs():
    #초기값 넣기
    visited = set()
    q = deque([])
    q.append((Sr -1,Sc - 1,0))
    while q:
        cur_r, cur_c, cnt = q.popleft()
        #목적지 도착
        if (cur_r,cur_c) in visited:
            continue
        visited.add((cur_r,cur_c))
        if cur_r == Fr - 1 and cur_c == Fc - 1:
            print(cnt)
            return
        else:
            for d in range(4):
                if move_check(cur_r, cur_c, d):
                    q.append((cur_r + d_r[d], cur_c + d_c[d], cnt + 1))

    print(-1)
    return

bfs()
