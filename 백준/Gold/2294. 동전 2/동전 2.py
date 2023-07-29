import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

n, k = map(int,input().split())

coin_list = deque([])
dp = deque([10001]*(k+1))
dp[0] = 0
for i0 in range(n):
    coin_list.append(int(input()))

for coin in coin_list:
    for i1 in range(coin,k+1):
        dp[i1] = min(dp[i1],dp[i1-coin]+1)
if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])