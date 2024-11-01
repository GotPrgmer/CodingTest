import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
info = list(map(int,input().split()))

dp = [0]*(n+1)

for i in range(1,n+1):
    dp[i] = max(dp[i-1],0)+info[i-1]
print(max(dp[1:]))