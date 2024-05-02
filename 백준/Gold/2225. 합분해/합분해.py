import sys

def input():
    return sys.stdin.readline().rstrip()

N, K = map(int,input().split())

dp = [[0]*K for _ in range(N)]

for k in range(K):
    for n in range(N):
        if k == 0:
            dp[n][k] = 1
        elif n == 0:
            dp[n][k] = k+1
        else:
            dp[n][k] = dp[n][k-1] + dp[n-1][k]
print(dp[N-1][K-1]%1000000000)