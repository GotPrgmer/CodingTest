import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

N = int(input())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
dp = [0 for _ in range(N+1)]
time = [0 for _ in range(N+1)]
q = deque([])

for i0 in range(1,N+1):
    input_lst = list(map(int,input().split()))
    time[i0] = input_lst[0]

    if input_lst[1] != 0:
        for i1 in range(2,len(input_lst)):
            indegree[i0] += 1
            graph[input_lst[i1]].append(i0)

for i in range(1,N+1):
    if indegree[i] == 0:
        dp[i] = time[i]
        q.append(i)
while q:
    cur = q.popleft()
    for next in graph[cur]:
        indegree[next] -= 1
        dp[next] = max(dp[next], dp[cur] + time[next])
        if indegree[next] == 0:
            q.append(next)


print(max(dp))


