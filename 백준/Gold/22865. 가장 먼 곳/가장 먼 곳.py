import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

def dijkstra(s):
    distance = [float('INF')]*(1+N)
    visited = [False]*(N+1)
    pq = []
    #출발지 초기화
    distance[s] = 0
    #초기값 힙에 넣기
    heapq.heappush(pq, (0, s))  # 우선 순위 큐에는 (거리, 노드) 쌍을 넣습니다.

    while pq:
        dist, cur = heapq.heappop(pq)
        if visited[cur]:
            continue

        visited[cur] = True
        for edge_dist, node in graph[cur]:
            if distance[node] > dist + edge_dist:
                distance[node] = dist + edge_dist
                heapq.heappush(pq, (distance[node], node))
    return distance


N = int(input())
A, B, C = map(int,input().split())

M = int(input())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    D, E, distance = map(int,input().split())
    graph[D].append([distance, E])
    graph[E].append([distance, D])
ans = [0]
distance_A = dijkstra(A)
distance_B = dijkstra(B)
distance_C = dijkstra(C)
for node in range(1,N+1):
    ans.append(min(distance_A[node],distance_B[node],distance_C[node]))

print(ans.index(max(ans)))
