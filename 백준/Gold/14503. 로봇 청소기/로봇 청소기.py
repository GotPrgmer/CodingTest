import sys

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)
def input():
    return sys.stdin.readline().rstrip()


def sol(cur_r,cur_c,cur_d):
    global ans
    # 현재칸이 청소 되지 않은 경우, 현재칸 청소

    if space_status[cur_r][cur_c] == 0:
        space_status[cur_r][cur_c] = -1
        ans += 1

    #주변 4칸 사방 탐색
    flag = 0
    for d in range(4):
        n_r = cur_r + d_r[d]
        n_c = cur_c + d_c[d]
        #다음칸 탐색
        if 0<=n_r<N and 0<=n_c<M and space_status[n_r][n_c] == 0:
            #청소되지 않은 빈칸이 있음!
            flag = 1
            break
    #청소되지 않은 빈칸이 없을 경우는 flag = 0
    if flag == 0:
        #현재 방향에서 뒤로 후진
        #후퇴방향
        back_d = (cur_d+2)%4
        back_r = cur_r + d_r[back_d]
        back_c = cur_c + d_c[back_d]

        # 뒤로 후퇴할 수 있다면
        if 0<=back_r<N and 0<=back_c<M and space_status[back_r][back_c] != 1:
            sol(back_r,back_c,cur_d)
        # 뒤로 후퇴할 수 없다면
        else:
            return
    #청소되지 않은 빈칸이 있을 경우
    else:
        turn_d = (cur_d - 1)%4
        n_r = cur_r + d_r[turn_d]
        n_c = cur_c + d_c[turn_d]
        if 0<=n_r<N and 0<=n_c<M and space_status[n_r][n_c] == 0:
            sol(n_r,n_c,turn_d)
        else:
            sol(cur_r, cur_c, turn_d)




N, M = map(int,input().split())

#처음 위치, 바라보는 방향 d
init_r, init_c, init_d = map(int,input().split())

#장소 상태 입력
space_status = [list(map(int,input().split())) for _ in range(N)]

ans = 0

sol(init_r,init_c,init_d)


print(ans)


