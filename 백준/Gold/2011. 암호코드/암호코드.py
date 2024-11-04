import sys

def input():
    return sys.stdin.readline().rstrip()

n = list(map(int,input()))
l = len(n)
dp = [0]*(l+1)
if n[0] == 0:
    print('0')
else:
    n = n
    dp[0]=dp[1]=1
    for i in range(1,l):
        if 9>=n[i] >0:
            dp[i+1] += dp[i]
        tmp = n[i-1]*10 + n[i]
        if 10 <= tmp <= 26:
            dp[i+1] += dp[i-1]
    print(dp[l]%1000000)