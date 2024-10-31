import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
wine = [0]*10001
dp = [0]*10001
for i in range(1,n+1):
    wine[i] = int(input())
dp[1] = wine[1]
dp[2] = wine[1]+wine[2]
dp[3] = max(wine[3]+dp[1],wine[3]+wine[2]+dp[0],dp[2])
for i in range(4,n+1):
    dp[i] = max(wine[i]+dp[i-2],wine[i]+wine[i-1]+dp[i-3],dp[i-1])
print(dp[n])