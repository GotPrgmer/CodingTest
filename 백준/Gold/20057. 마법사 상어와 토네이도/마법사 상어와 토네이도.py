import sys

def input():
    return sys.stdin.readline().rstrip()

d_r = (0,1,0,-1)
d_c = (-1,0,1,0)

N = int(input())
sand_board = [list(map(int,input().split())) for _ in range(N)]
#x에서 y로 토네이도가 이동할 때 y의 모래가 각각 흩어지는 것을 계산

def rotate_90(rate):
    return list(reversed(list(zip(*rate))))

rate=[[0,0,0.02,0,0],
      [0,0.1,0.07,0.01,0],
      [0.05,0,0,0,0],
      [0,0.1,0.07,0.01,0],
      [0,0,0.02,0,0]]
rate2 = rotate_90(rate)
rate3 = rotate_90(rate2)
rate4 = rotate_90(rate3)
rates = [rate,rate2,rate3,rate4]
def sand(change_r,change_c,d):
    global ans
    amount = sand_board[change_r][change_c]
    res = amount
    cur_r = change_r
    cur_c = change_c
    for r in range(5):
        for c in range(5):
            now_sand = int(amount*rates[d][r][c])
            res -= now_sand
            if 0<=cur_r-2+r<N and 0<=cur_c-2+c<N:
                sand_board[cur_r-2+r][cur_c-2+c] += now_sand
            else:
                ans += now_sand
    sand_board[cur_r][cur_c] = 0
    if 0<=cur_r+d_r[d]<N and 0<=cur_c+d_c[d]<N:
        sand_board[cur_r+d_r[d]][cur_c+d_c[d]] += res
    else:
        ans += res


#토네이도의 이동 중심부터 (0,0)까지 가서 소멸
def tornado(r,c):
    d = 0
    #몇번 갔는지
    cnt0 = 0
    #현재 목표가 몇인지
    turn = 1
    #같은 숫자를 두번 돌면 숫자가 turn하나 올라가게 하자
    cnt_turn = 0
    while not (r == 0 and c == 0):
        #모래계산
        sand(r+d_r[d],c+d_c[d],d)
        #cnt의 몫이 올라가면 방향을 전환
        r +=d_r[d]
        c +=d_c[d]
        cnt0 += 1

        if cnt0 == turn:
            cnt_turn += 1
            cnt0 = 0
            d = (d+1)%4
        if cnt_turn == 2:
            cnt_turn = 0
            turn += 1
    return
ans = 0
tornado(N//2,N//2)
print(ans)






#방향에따라 모래가 이동하는 것도 고려해아함