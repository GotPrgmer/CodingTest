import sys

def input():
    return sys.stdin.readline().rstrip()


def sol():
    #플로이드 와샬
    #초기화

    for mid in range(1,N+1):
        for start in range(1,N+1):
            if dp[start][mid] != M*100:
                for end in range(1,N+1):
                    if start == end:
                        dp[start][end] = 0
                    else:
                        dp[start][end] = min(dp[start][end],
                                             dp[start][mid]+dp[mid][end])
    return dp
N, M, X = map(int,input().split())
dp = [[M*100] * (N + 1) for _ in range(N + 1)]
for _ in range(M):
    s, e, T = map(int,input().split())
    dp[s][e] = T

dp = sol()
ans = 0
for i in range(1,N+1):
    ans = max(ans,dp[i][X]+dp[X][i])
print(ans)