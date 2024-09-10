import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()
def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def union(x,y):
    x = find(x)
    y = find(y)
    if x<y:
        parents[y]=x
    else:
        parents[x] = y
N, M = map(int,input().split())
parents = [i for i in range(N+1)]
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)


ctp, hansol, K = map(int,input().split())

for a in range(1,N+1):
    for b in graph[a]:
        if find(a) == find(b):
            continue
        else:
            union(a,b)

group = defaultdict(int)
for i in range(1,N+1):
    root = find(i)
    group[root] += 1
ans = group[ctp]
for key, val in sorted(group.items(), key=lambda x:x[1],reverse=True):
    if key == ctp or key == hansol:
        continue
    if K <= 0:
        break
    ans += val
    K -= 1
print(ans)

