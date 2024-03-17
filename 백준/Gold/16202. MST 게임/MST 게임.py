import sys
input = sys.stdin.readline


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)

    if level[a] >= level[b]:
        parent[b] = a
        if level[a] == level[b]:
            level[a] += 1
    else:
        parent[a] = b

N, M, K = map(int, input().split())
edges = []
for i in range(1,M+1):
    a, b = map(int, input().split())
    edges.append((i,a,b))
for i in range(K):
    answer = 0
    cnt = 0
    parent = {i: i for i in range(1,N+1)}
    level = {i: 0 for i in range(1,N+1)}
    for edge in edges[i:]:
        c, a, b = edge
        if find(a) != find(b):
            union(a,b)
            cnt += 1
            answer += c
        if cnt == N-1:
            print(answer, end = ' ')
            break
    else:
        print(0, end=' ')