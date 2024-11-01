import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
dp = [0 for _ in range(N+1)]
if N>=2:
    dp[2] = 3
    for i in range(1,N+1):
        if i%2==0:
            for j in range(2,N+1,2):
                if j == 2:
                    dp[i] += 3*dp[i-j]
                elif i-j != 0:
                    dp[i] += dp[i-j]*2
                else:
                    dp[i] += 2
print(dp[-1])