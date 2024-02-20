# A에서 B로 가는 다리중에서 최소값들 중
# 최대인 것을 호출하는 문제이다.
# A에서 B로 가는 모든 경우를 봐야함
# 최종 도착지에 도달할때까지 경로를 추적해서
# 두 섬사이에 다리가 여러개 있을 수 있으므로
# 지금까지의 값

import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def bfs(mid):
    # 현재 위치랑 경로에서 값의 최소값을 가지고 가야함
    #
    q = deque()
    q.append(s)
    visited[s] = True

    while q:
        cur = q.popleft()
        if cur == e:
            return True

        for node, cost in graph[cur]:
            if not visited[node] and mid <= cost:
                q.append(node)
                visited[node] = True

    return False



N, M = map(int,input().split())
graph = [[] for _ in range(N+1)]

#그래프 입력
for _ in range(M):
    A, B, C = map(int,input().split())
    graph[A].append([B,C])
    graph[B].append([A,C])

s, e = map(int,input().split())
l, r = 0, int(10**9)

ans = 0
while l <= r:
    mid = (l + r ) // 2
    visited = [False for _ in range(N+1)]

    if bfs(mid):
        ans = max(ans, mid)
        l = mid + 1
    else:
        r = mid - 1

print(ans)


