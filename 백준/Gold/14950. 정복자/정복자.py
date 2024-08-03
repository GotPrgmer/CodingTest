import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

def solve():
    #출발 1
    q = []
    for i in graph[1]:
        heapq.heappush(q,i)
    visited = set()
    visited.add(1)
    ans = 0
    while q and len(visited) != N:
        cost, node = heapq.heappop(q)
        if node in visited:
            continue
        ans += max(len(visited) -1,0)*t + cost

        visited.add(node)
        #주위 도착 노드로 엣지 추가
        for i in graph[node]:
            heapq.heappush(q,i)
    return ans

#프림으로 구현 시간복잡도 ElogV이기 때문!
N, M , t = map(int,input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A, B, C = map(int,input().split())
    graph[A].append([C,B])
    graph[B].append([C,A])
print(solve())