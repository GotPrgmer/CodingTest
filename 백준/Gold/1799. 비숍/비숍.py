import sys

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,1,1,-1)
d_c = (1,1,-1,-1)
def backtracking_even(r,c,cnt):
    global ans
    if r == N:
        ans = max(ans, cnt)
        return

    if board[r][c] == 1:
        if condition(r, c):
            #N이 짝수일때 예외


            visited[r][c] = True
            #r이 홀수일 때
            if r % 2:
                if c + 2 >= N:
                    if flag == 0:
                        backtracking_even(r + 1, 0, cnt + 1)
                    else:
                        backtracking_even(r + 1, 1, cnt + 1)
                else:
                    backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt + 1)
            else:
                if c + 2 >= N:
                    if flag == 0:
                        backtracking_even(r + 1, 1, cnt + 1)
                    else:
                        backtracking_even(r + 1, 0, cnt + 1)
                else:
                    backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt + 1)
            visited[r][c] = False
        if r % 2:
            if c + 2 >= N:
                if flag == 0:
                    backtracking_even(r + 1, 0, cnt)
                else:
                    backtracking_even(r + 1, 1, cnt)
            else:
                backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt)
        else:
            if c + 2 >= N:
                if flag == 0:
                    backtracking_even(r + 1, 1, cnt)
                else:
                    backtracking_even(r + 1, 0, cnt)
            else:
                backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt)
    else:
        if r % 2:
            if c + 2 >= N:
                if flag == 0:
                    backtracking_even(r + 1, 0, cnt)
                else:
                    backtracking_even(r + 1, 1, cnt)
            else:
                backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt)
        else:
            if c + 2 >= N:
                if flag == 0:
                    backtracking_even(r + 1, 1, cnt)
                else:
                    backtracking_even(r + 1, 0, cnt)
            else:
                backtracking_even(r + (c + 2) // N, (c + 2) % N, cnt)


def backtracking_odd(r,c,cnt):
    global ans
    if r == N:
        ans = max(ans, cnt)
        return

    if board[r][c] == 1:
        if condition(r, c):
            visited[r][c] = True
            backtracking_odd(r + (c+2)//N,(c+2)%N, cnt+1)
            visited[r][c] = False
        backtracking_odd(r + (c + 2) // N, (c + 2) % N, cnt)
    else:
        backtracking_odd(r + (c + 2) // N, (c + 2) % N, cnt)


def condition(r,c):
    #4방향의 모든 대각선에 visited가 False여야함
    for d in range(4):
        start_r = r
        start_c = c
        if visited[start_r][start_c] == True:
            return False
        else:
            while 0<=start_r<N and 0<= start_c<N:
                if visited[start_r][start_c] == True:
                    return False
                start_r += d_r[d]
                start_c += d_c[d]
    return True

N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]
visited = [[False]*(N) for _ in range(N)]
ans = 0
if N % 2:
    backtracking_odd(0,0,0)
    visited = [[False] * (N) for _ in range(N)]
    backtracking_odd(0,1,ans)
else:
    flag = 0
    backtracking_even(0, 0, 0)
    flag += 1
    visited = [[False] * (N) for _ in range(N)]
    backtracking_even(0, 1, ans)
print(ans)


