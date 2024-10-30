import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
dp = [[0]*10 for _ in range(N+1)]
dp[1] = [1,1,1,1,1,1,1,1,1,1]
for i in range(2,N+1):
    for k in range(0,10):
        partial_sum = sum(dp[i-1][0:k+1])
        dp[i][k] = partial_sum
print(sum(dp[-1])%10007)