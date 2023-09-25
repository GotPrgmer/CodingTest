import sys

def input():
    return sys.stdin.readline().rstrip()


N, M = map(int,input().split())

dp = [[-1]*(N+1)]+[[-1]+list(map(int,input().split())) for _ in range(N)]
for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            dp[i][j] = min(dp[i][j],dp[i][k]+dp[k][j])

for _ in range(M):
    s, e, c = map(int,input().split())


    # 초기값
    if dp[s][e] <= c:
        print('Enjoy other party')
    else:
        print('Stay here')
