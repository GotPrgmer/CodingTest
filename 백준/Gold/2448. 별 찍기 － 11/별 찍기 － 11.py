import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
star = [[' ' for _ in range(N*2)] for _ in range(N)]

def go(x, y, n):
    if n <= 3:
        for i in range(3):
            for j in range(i+1):
                star[x+i][y+j] = star[x+i][y-j] = '*'
        star[x+1][y] = ' '
        return
    m = n // 2
    go(x, y, m)
    go(x+m, y-m, m)
    go(x+m, y+m, m)

go(0, N-1, N)

for i in range(N):
    print("".join(star[i]))