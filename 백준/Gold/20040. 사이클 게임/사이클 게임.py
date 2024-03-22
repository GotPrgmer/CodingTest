import sys
input = sys.stdin.readline

n, m = map(int, input().split())
parents = [i for i in range(n)]
endgame = 0

def find(x):
    if x == parents[x]:
        return x
    else:
        y = find(parents[x])
        parents[x] = y
        return y

def union(x, y, indx):
    global endgame
    x = find(x)
    y = find(y)
    if x != y:
        parents[max(x,y)] = min(x,y)
    elif endgame == 0:
        endgame = indx

for i in range(m):
    a, b = map(int, input().split())
    union(a, b, i + 1)

print(endgame)