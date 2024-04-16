import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
relation = [0 for _ in range(N+1)]

graph = [[] for _ in range(N+1)]
for i in range(M):
    A, B = map(int,input().split())
    graph[A].append(B)
    graph[B].append(A)

for i in range(1,N+1):
    if relation[i] == 0:

        q = deque([])
        q.append(i)
        relation[i] = 1
        while q:
            cur = q.popleft()
            for nt in graph[cur]:
                if relation[nt] == 0:
                    relation[nt] = relation[cur]*(-1)
                    q.append(nt)
                elif relation[nt] == relation[cur]:
                    print(0)
                    exit()

print(1)
