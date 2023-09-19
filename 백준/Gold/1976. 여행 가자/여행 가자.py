import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

M = int(input())

connect = [[] for _ in range(N+1)]
for i0 in range(1,N+1):
    info = [0]+list(map(int,input().split()))
    for i1 in range(1,len(info)):
        if info[i1] == 1:
            connect[i0].append(i1)
parents = list(range(N+1))
tourlist = list(map(int,input().split()))


#유니온 파인드

def union(a,b):
    a = find(a)
    b = find(b)
    if a > b:
        parents[a] = b
    else:
        parents[b] = a

def find(a):
    if parents[a] != a:
        parents[a] = find(parents[a])
    return parents[a]

for i1 in range(1,N+1):
    for i2 in connect[i1]:
        union(i1,i2)

ans = "YES"
for i2 in range(1,M):
    if parents[tourlist[i2]] != parents[tourlist[0]]:
        ans = "NO"
        break

print(ans)





