def solution(n):
    dp=[0,1,2]
    if n <=2:
        return dp[n]%1234567
    else:
        for i in range(3,n+1):
            dp.append(dp[i-1]+dp[i-2])
        return dp[n]%1234567