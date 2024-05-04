import sys
import math
import heapq

def input():
    return sys.stdin.readline().rstrip()

def prim():
    q = []
    heapq.heappush(q,(0,0))
    visited = set()
    ans = 0
    while q:
        cur_cost, cur_point = heapq.heappop(q)
        if len(visited) == n:
            break
        if cur_point in visited:
            continue
        ans += cur_cost
        visited.add(cur_point)

        for star in graph[cur_point]:
            if start[1] not in visited:
                heapq.heappush(q,(star[0],star[1]))


    return ans


n = int(input())

graph = [[] for _ in range(n)]
points = []
for _ in range(n):
    x, y = map(float,input().split())
    points.append((x,y))

for i in range(len(points)):
    for j in range(i+1,len(points)):
        start = points[i]
        end = points[j]
        length = round(math.sqrt((start[0]-end[0])**2+(start[1] - end[1])**2),2)
        graph[i].append((length,j))
        graph[j].append((length,i))

print(prim())
