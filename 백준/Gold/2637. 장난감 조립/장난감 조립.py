import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def sol():
    for node in range(1,N+1):
        if degree[node] == 0:
            q.append(node)

    while q:
        cur = q.popleft()

        for n_node, n_cost in graph[cur]:
            if needs[cur].count(0) == N+1:
                needs[n_node][cur] += n_cost

            else:
                for bupum in range(1,N+1):
                    needs[n_node][bupum] += needs[cur][bupum]*n_cost

            degree[n_node] -= 1
            if degree[n_node] == 0:
                q.append(n_node)

    for info in enumerate(needs[N]):
        if info[1] >= 1:
            print(*info)

N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
needs = [[0] * (N+1) for _ in range(N+1)]



q = deque()
degree = [0]*(N+1)
for _ in range(M):
    X, Y, K = map(int,input().split())
    graph[Y].append((X,K))
    degree[X] += 1
sol()