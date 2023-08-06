import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N, K = map(int,input().split())
items = deque([])

for _ in range(N):
    W, V = map(int,input().split())
    items.append((W,V))

dp = [0]*(K+1)

for it in items:
    for put in range(K,0,-1):
        if put >= it[0]:
            if dp[put] < dp[put-it[0]]+it[1]:
                dp[put] = dp[put-it[0]]+it[1]

print(dp[-1])



