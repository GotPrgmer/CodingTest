import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

def sol():
    #다익스트라 M번 쓰면된다고 생각했음
    for question in Question:
        q = []
        start = question[0]
        end = question[1]
        distance = [float('INF')]*(N+1)
        heapq.heappush(q,(0,start))
        distance[start] = 0

        while q:
            dist, cur = heapq.heappop(q)
            if distance[cur] < dist:
                continue

            for i in graph[cur]:
                cost = dist + i[1]
                if cost < distance[i[0]]:
                    distance[i[0]] = cost
                    heapq.heappush(q,(cost,i[0]))
        print(distance[end])



N, M = map(int,input().split())
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    point1,point2, dist = map(int,input().split())
    graph[point1].append((point2, dist))
    graph[point2].append((point1, dist))

Question = []
for _ in range(M):
    ans1, ans2 = map(int,input().split())
    Question.append((ans1,ans2))

sol()