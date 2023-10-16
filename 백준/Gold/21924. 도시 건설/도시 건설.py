import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
graph = [[] for _ in range(N+1)]
original_sum = 0

for _ in range(M):
    s, e , c = map(int,input().split())
    graph[s].append((e,c))
    graph[e].append((s, c))
    original_sum += c

connected = [False] * (N)
sum_c = 0
def prim(start):
    global sum_c
    heap = []


    heapq.heappush(heap,(0,start))

    while heap:
        cost, v = heapq.heappop(heap)

        if not connected[v-1]:
            connected[v-1] = True
            sum_c += cost
            for i1 in graph[v]:
                if not connected[i1[0]-1]:
                    heapq.heappush(heap,(i1[1],i1[0]))

prim(1)
if False in connected:
    print(-1)
else:
    print(original_sum - sum_c)