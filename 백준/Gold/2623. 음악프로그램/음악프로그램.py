import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
indegree = [0 for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for _ in range(M):
    order = list(map(int,input().split()))
    for i0 in range(1,len(order)-1):
        graph[order[i0]].append(order[i0+1])
        indegree[order[i0+1]] += 1


def topology():
    q = deque([])
    result = []
    for i1 in range(1,len(indegree)):
        if indegree[i1] == 0:
            q.append(i1)

    while q:
        cur_node = q.popleft()
        result.append(cur_node)
        for i2 in graph[cur_node]:
            indegree[i2] -= 1
            if indegree[i2] == 0 and i2 not in result:
                q.append(i2)

    if len(result) != N:
        print(0)
    else:
        for node in result:
            print(node)

topology()



