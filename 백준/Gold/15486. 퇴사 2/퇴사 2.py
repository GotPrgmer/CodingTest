import sys

def input():
    return sys.stdin.readline().rstrip()

cost_lst = [(-1,-1)]
N = int(input())
dp = [0 for _ in range(N+1)]

for _ in range(N):
    T, P = map(int,input().split())
    cost_lst.append((T,P))
ans = 0
#i1은 일
for i0 in range(1,N+1):
    #이전에 가져온경우와 가지고오지 않은 경우중에 선택했는지 안했는지 둘다 고려한 코드라인
    dp[i0] = max(dp[i0],dp[i0-1])
    if i0 + cost_lst[i0][0]-1<= N:
        dp[i0 + cost_lst[i0][0]-1] = max(dp[i0 + cost_lst[i0][0] - 1],dp[i0-1]+cost_lst[i0][1])

print(dp[N])
