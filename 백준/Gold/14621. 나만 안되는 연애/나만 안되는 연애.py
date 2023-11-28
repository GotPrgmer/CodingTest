import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

sex = list(input().split())

relation = [ [] for _ in range(N+1)]

for _ in range(M):
    u, v, cost = map(int,input().split())
    if sex[u-1] != sex[v-1]:
        relation[u].append((cost, v))
        relation[v].append((cost, u))

visited = [0]*(N+1)

q = []
#1부터 시작
heapq.heappush(q,(0,1))
ans = 0

while q:
    c, node = heapq.heappop(q)
    if visited[node] == 0:
        visited[node] = 1
        ans += c
        for next_c, next_node in relation[node]:
            heapq.heappush(q,(next_c,next_node))

if sum(visited) == N:
    print(ans)
else:
    print(-1)