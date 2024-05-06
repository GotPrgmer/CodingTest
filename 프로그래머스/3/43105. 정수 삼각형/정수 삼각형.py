def solution(triangle):
    dp = [[0]*(i+1) for i in range(len(triangle))]
    #마지막 행 채워넣기
    dp[-1] = triangle[-1]
    for h in range(len(triangle)-2,-1,-1):
        #h-1에서 0으로 가면서 왼쪽 오른쪽 비교하면서 현재 값을 채워넣기
        for nth in range(len(triangle[h])):
            dp[h][nth] = triangle[h][nth] + max(dp[h+1][nth],dp[h+1][nth+1])
    answer = 0
    return dp[0][0]