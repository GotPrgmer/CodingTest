import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

distance = []
graph = [[] for _ in range(N+1)]
dp = [ [float('INF')]*(N+1) for _ in range(N+1)]
#자기 자신으로 가면 0
for i in range(1,N+1):
    dp[i][i] = 0

for _ in range(M):
    A, B = map(int,input().split())

    graph[A].append(B)
    graph[B].append(A)
    dp[A][B] = 1
    dp[B][A] = 1


#플로이드 와샬
for i in range(1,N+1):
    for j in range(1,N+1):
        for k in range(1,N+1):
            dp[j][k] = min(dp[j][i]+dp[i][k],dp[j][k])

#모든 구간에 대해서
for i in range(1,N+1):
    for j in range(i+1,N+1):
        sum_distance = 0
        for k in range(1,N+1):
            sum_distance += min(dp[i][k]*2,dp[j][k]*2)
        distance.append([i,j,sum_distance])

distance.sort(key= lambda x:(x[2],x[1],x[0]))
print(*distance[0])

