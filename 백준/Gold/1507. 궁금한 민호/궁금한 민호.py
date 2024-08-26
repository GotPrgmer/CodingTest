import sys
import heapq



N = int(input())
floid = []
for _ in range(N):
    floid.append(list(map(int,input().split())))
dp = [[True]*N for _ in range(N)]
result = 0
for m in range(N):
    for i in range(N):
        if i != m:
            for j in range(N):
                if i != m and m != j:
                    if floid[i][j] == floid[i][m] + floid[m][j]:
                        dp[i][j] = False
                    elif floid[i][j] > floid[i][m] + floid[m][j]:
                        print(-1)
                        exit()
ans = 0
for i in range(N):
    for j in range(i,N):
        if dp[i][j] == True:
            ans += floid[i][j]
print(ans)
