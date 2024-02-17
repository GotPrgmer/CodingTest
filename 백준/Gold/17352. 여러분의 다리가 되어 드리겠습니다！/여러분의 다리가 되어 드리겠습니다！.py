import sys

def input():
    return sys.stdin.readline().rstrip()

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

N = int(input())
parent = [i for i in range(N+1)]

for _ in range(N - 2):
    a, b = map(int,input().split())
    union(a,b)

ans = []
for bridge in range(1,N+1):
    if bridge == parent[bridge]:
        ans.append(bridge)
print(*ans)
