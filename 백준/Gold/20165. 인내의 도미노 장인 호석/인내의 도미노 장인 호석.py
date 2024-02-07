# 각 도미노는 1이상 5 이하
# 공격수가 먼저 공격하고 수비수는 그 후에 수비
# 공격수가 동서남북 중 원하는 방향에 도미노를 쓰러트림
# 길이가 K인 도미노가 특정 방향으로 넘어지면 그 방향으로 K-1개 도미노들 중
# 아직 넘어지지 않은 것들이 해당 방향으로 연달아 넘어짐

# 이미 넘어진 도미노가 있는 칸을 공격한 경우 아무 일이 일어나지 않음
# 넘어지면서 남은 카운트를 계속해서 갱신해줘야함

# 수비수는 넘어져있는 도미노중 원하는 것 하나를 다시 세울 수 있음
# 넘어지지 않은 도미노를 세우려고 하면 아무 일도 일어나지 않는다.

# 총 R번의 라운드 동안 공격수와 수비수가 번갈아 취하는 행동만이 반복된다.
# 매 라운드 마다 공격수가 해당 라운드에 넘어뜨린 도미노 개수를 세고, R 란운드에 걸친
# 총합이 곧 공격수의 점수가 됨.

import sys
from copy import deepcopy

def input():
    return sys.stdin.readline().rstrip()
delta_dict = {'E':(0,1),'W':(0,-1),'S':(1,0),'N':(-1,0)}

#r, c, d를 입력
def attack(r, c, d):
    mv_r = r
    mv_c = c

    # r,c로 가서 d방향으로 넘어뜨리기 시작
    # 만약 1이상일때 동작
    fallen = 0
    if board[r][c]:
        fallen += 1
        cnt = board[r][c]
        #0으로 만들기
        board[r][c] = 0
        cnt -= 1
        d_r = delta_dict[d][0]
        d_c = delta_dict[d][1]
        #특정 방향으로 도미노 쓰러지기
        while cnt:
            #좌표 하나 움직이기
            mv_r += d_r
            mv_c += d_c

            #해당 좌표가 영역 내인지 확인
            if 0<= mv_r < N and 0<= mv_c < M:
                if board[mv_r][mv_c]:
                    fallen += 1
                    cnt = max(cnt, board[mv_r][mv_c])
                    board[mv_r][mv_c] = 0
                # cnt 하나 줄이기
                cnt -= 1
            else:
                #영역을 벗어났으니 종료

                return fallen
        return fallen

    else:
        return 0


def defense(r,c):
    #원하는 r, c 값을 되살리기
    board[r][c] = backup_board[r][c]



N, M, R = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(N)]
backup_board = deepcopy(board)
ans = 0
for round in range(R):
    #attsck
    a_r, a_c, d = input().split()
    ans += attack(int(a_r) - 1,int(a_c) - 1,d)
    #defense
    d_r, d_c = map(int,input().split())
    defense(d_r - 1, d_c - 1)

# 정답 도출
print(ans)
for r in range(N):
    for c in range(M):
        if c < M - 1 :
            if board[r][c] : print('S',end =' ')
            else : print('F',end =' ')
        else :
            if board[r][c] : print('S',end ='')
            else : print('F',end ='')
    if r < N - 1:
        print()



