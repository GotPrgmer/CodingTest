import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
pq = []
dp_list = []

#초기값을 힙큐에 넣어서 모든 정점을 고려한 프림을 만드는 준비를 함
for node in range(N):
    this_cost = int(input())
    dp_list.append(this_cost)
    heapq.heappush(pq,(this_cost,node))

arr = [list(map(int,input().split())) for _ in range(N)]

ans = 0
visited = [False]*N
while pq:
    cost, cur_node = heapq.heappop(pq)
    if visited[cur_node]:
        continue
    visited[cur_node] = True
    ans += cost

    for next_node in range(N):
        #나말고 다른 노드와는 다 연결이 되어있음!
        if next_node != cur_node:
            if dp_list[next_node] > arr[cur_node][next_node]:
                dp_list[next_node] = arr[cur_node][next_node]
                heapq.heappush(pq,(dp_list[next_node],next_node))

print(ans)





