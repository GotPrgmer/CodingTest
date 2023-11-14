import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N, W = map(int,input().split())

M = float(input())

coor = [[]]
graph = [[] for _ in range(N+1)]

for _ in range(N):
    x, y = map(int,input().split())
    coor.append([x,y])

#모든 거리 넣기
for i0 in range(1,N+1):
    for i1 in range(i0+1,N+1):
        distance = (abs(coor[i0][0]-coor[i1][0])**2 + abs(coor[i0][1]-coor[i1][1])**2)**(1/2)
        if distance <= M:
            graph[i0].append([i1,distance])
            graph[i1].append([i0, distance])

#서로 연결된 것들 0으로 세팅

for i2 in range(1,W+1):
    p1,p2 = map(int,input().split())
    graph[p1].append([p2,0])
    graph[p2].append([p1,0])

def dijkstra():
    current_distance = [float('INF') for _ in range(N+1)]
    current_distance[1] = 0
    pq = []
    heapq.heappush(pq,[0,1])

    while pq:
        current_cost, current_node = heapq.heappop(pq)
        if current_distance[current_node] < current_cost:
            continue
        for next_node, next_distance in graph[current_node]:
            if current_distance[next_node] > next_distance + current_cost:
                current_distance[next_node] = next_distance + current_cost
                heapq.heappush(pq,[current_distance[next_node],next_node])
    return int(current_distance[N]*1000)
print(dijkstra())


