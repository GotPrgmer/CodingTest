import sys,math

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
dp = [i for i in range(N+1)]
square = []
for i in range(1,N+1):
    for j in range(1,i):
        if i<j**2:
            break
        if dp[i]>dp[i-j**2]+1:
            dp[i] = dp[i-j**2]+1
print(dp[-1])