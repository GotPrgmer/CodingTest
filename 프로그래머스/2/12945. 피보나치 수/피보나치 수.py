import sys
sys.setrecursionlimit(10**6)
def solution(n):
    dp = [0,1]
    def fibonaci(x):
        if len(dp)>=x+1:
            return dp[x]
        dp.append(fibonaci(x-2)+fibonaci(x-1))
        return dp[x]
    return fibonaci(n)%1234567