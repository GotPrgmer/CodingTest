import sys

def input():
    return sys.stdin.readline().rstrip()

def find(x):
    global parents
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

def union(x, y, indx):
    global endgame
    x = find(x)
    y = find(y)
    if x != y:
        parents[max(x,y)] = min(x,y)
    elif endgame == 0:
        endgame = indx
n, m = map(int, input().split())
parents = [i for i in range(n)]
endgame = 0

for i in range(m):
    a, b = map(int, input().split())
    union(a, b, i + 1)
    if endgame != 0:
        print(endgame)
        break
if endgame == 0:
    print(endgame)