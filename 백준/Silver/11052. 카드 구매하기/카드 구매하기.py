import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
costs = list(map(int,input().split()))
#i개의 카드 구매를 위한 최대 비용
dp = [0 for _ in range(N+1)]
dp[1] = costs[0]
for i in range(2,N+1):
    dp[i] = costs[i-1]
    for j in range(i):
        dp[i] = max(dp[i],dp[j]+dp[i-j])
print(dp[-1])