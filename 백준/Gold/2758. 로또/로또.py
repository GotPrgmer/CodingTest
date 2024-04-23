import sys

def input():
    return sys.stdin.readline().rstrip()

dp = [[0]*2001 for _ in range(11)]
dp[0][0] = 1
for i in range(1,11):
    for j in range(1,2001):
        dp[i][j] = sum(dp[i-1][k] for k in range(j//2+1))

T = int(input())
for _ in range(T):
    n, m = map(int,input().split())
    print(sum(dp[n][k] for k in range(2**(n-1),m+1)))
