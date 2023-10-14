import sys
sys.setrecursionlimit(10**4)

def input():
    return sys.stdin.readline().rstrip()

N, Q = map(int,input().split())
n = 2**N
ice_board = [list(map(int,input().split())) for _ in range(n)]
L = list(map(int,input().split()))
d_r = (-1,0,1,0)
d_c = (0,1,0,-1)


for rotate in L:
    #전체 판을 돌린다.
    k = 2**rotate
    for r in range(0,2**N,k):
        for c in range(0,2**N,k):
            tmp = [ice_board[i][c:c+k] for i in range(r,r+k)]
            for i in range(k):
                for j in range(k):
                    ice_board[r+j][c+k-i-1] = tmp[i][j]

    #인접한 얼음 카운팅
    cnt = [[0] * n for _ in range(n)]
    for x in range(0, n):
        for y in range(0, n):
            for d in range(4):
                nx, ny = x + d_r[d], y + d_c[d]
                if 0 <= nx < n and 0 <= ny < n and ice_board[nx][ny]:
                    cnt[x][y] += 1
    for x in range(0, n):
        for y in range(0, n):
            if ice_board[x][y] > 0 and cnt[x][y] < 3:
                ice_board[x][y] -= 1

print(sum(sum(i) for i in ice_board))

def dfs(x,y):
    global ice_board
    ret = 1
    ice_board[x][y] = 0
    for d in range(4):
        nx, ny = x+d_r[d], y+d_c[d]
        if 0<=nx<n and 0<=ny<n and ice_board[nx][ny]:
            ret += dfs(nx,ny)
    return ret

ans = 0
for x in range(n):
    for y in range(n):
        if ice_board[x][y] > 0:
            ans = max(ans, dfs(x,y))
print(ans)

