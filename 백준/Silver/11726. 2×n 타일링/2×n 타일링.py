import sys

def input():
    return sys.stdin.readline().rstrip()


n = int(input())
dp = [0,1,2]

if n<=2:
    print(dp[n])
else:
    for s in range(3,n+1):
        dp.append(dp[s-1]+dp[s-2])
    print(dp[n]%10007)