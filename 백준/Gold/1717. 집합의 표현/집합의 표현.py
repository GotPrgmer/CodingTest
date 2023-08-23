import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    else:
        if rank[a] < rank[b]:
            a, b = b, a
        parent[b] = a

        if rank[a] == rank[b]:
            rank[a] += 1




n, m = map(int,input().split())

parent = deque([])
rank = deque([])

for i0 in range(n+1):
    parent.append(i0)
    rank.append(1)

for _ in range(m):
    oper, first, second = map(int,input().split())


    if oper == 0:
        union(first,second)

    else:
        if find(first) == find(second):
            print("YES")
        else:
            print("NO")
