import sys

def input():
    return sys.stdin.readline().rstrip()
d_r = (-1,1,0,0)
d_c = (0,0,1,-1)

def store(r,c):
    global ans
    size = 0
    while -1 < r - size and r + size < N and -1 < c - size and c + size <M and \
        board[r-size][c] == board[r+size][c] == board[r][c - size] == board[r][c + size] == "#":
        size += 1
    while size:
        info.append((size,r,c))
        size -= 1



def test(info1,info2):
    visited = [[False]*M for _ in range(N)]
    d_info = [(-1,0),(1,0),(0,-1),(0,1)]
    size1 = info1[0]
    for s in range(size1):
        for d in range(4):
            visited[info1[1]+d_info[d][0]*s][info1[2]+d_info[d][1]*s] = True

    size2 = info2[0]
    for s in range(size2):
        for d in range(4):
            if visited[info2[1]+d_info[d][0]*s][info2[2]+d_info[d][1]*s]:
                return False
    return True


N, M = map(int,input().split())
board = [list(input()) for _ in range(N)]
info = []
ans = 0
for r in range(N):
    for c in range(M):
        if board[r][c] == "#":
            store(r,c)
            #십자가를 놓아 둘 수 있다!

for first in range(len(info) - 1):
    for second in range(first + 1,len(info)):
        tmp = (1+(info[first][0]-1)*4)*(1+(info[second][0]-1)*4)
        if test(info[first],info[second]):
            ans = max(ans,tmp)
print(ans)