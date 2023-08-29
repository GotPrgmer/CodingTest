import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()


def dijkstra():
    global start
    pq = [(0,start)]
    while pq:
        weight, u = heapq.heappop(pq)

        for next_w, next_v in graph[u]:
            updated_w = weight + next_w
            if updated_w < dist[next_v]:
                dist[next_v] = updated_w
                heapq.heappush(pq,(updated_w,next_v))



V, E = map(int,input().split())
INF = 999999
dist = [INF] * (V+1)
graph = [[] for _ in range(V+1)]

start = int(input())
dist[start] = 0

for _ in range(E):
    u, v, w = map(int,input().split())
    graph[u].append((w,v))

dijkstra()

for ans in range(1,len(dist)):
    if dist[ans] == INF:
        print("INF")
    else:
        print(dist[ans])


