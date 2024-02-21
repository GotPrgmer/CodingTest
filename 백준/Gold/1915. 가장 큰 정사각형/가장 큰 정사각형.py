import sys

def input():
    return sys.stdin.readline().rstrip()

n, m = map(int,input().split())

board = [list(map(int,input())) for _ in range(n)]

ans = 0
for r in range(1,n):
    for c in range(1,m):
        if board[r][c] == 1:
            board[r][c] =  min(board[r-1][c],board[r][c-1],board[r-1][c-1]) + 1
        ans = max(ans,board[r][c])

print(max(map(max, board)) ** 2)
