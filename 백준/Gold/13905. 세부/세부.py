import sys

from collections import deque
def input():
    return sys.stdin.readline().rstrip()

def check_bfs(limit):
    # 시작위치
    q = deque([s])
    visited = set()
    visited.add(s)
    while q:
        cur_node = q.popleft()
        if cur_node == e:
            return True

        # 이분탐색으로 고른 무게제한에 통과가능한가?
        for next_node in graph[cur_node]:
            if next_node[1] >= limit and next_node[0] not in visited:
                q.append(next_node[0])
                visited.add(next_node[0])
    return False

def sol():
    # 이분탐색
    start = 1
    end = max_value
    ans = 0
    while start <= end:
        mid = (start + end)//2
        if check_bfs(mid):
            start = mid + 1
            ans = max(ans,mid)
        else:
            end = mid - 1
    return ans




N, M = map(int,input().split())

s, e = map(int,input().split())

graph = [[] for _ in range(N+1)]
max_value = -float('INF')
for _ in range(M):
    # 그래프 정보 입력
    h1, h2, k = map(int,input().split())
    graph[h1].append([h2,k])
    graph[h2].append([h1, k])
    max_value = max(max_value,k)

print(sol())