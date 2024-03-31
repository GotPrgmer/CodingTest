import sys

def input():
    return sys.stdin.readline().rstrip()

def sol():
    #1부터 시작해서 최장 증가하는 수열을 구하자.
    dp = [1]*(N+1)
    for s_idx in range(1,N+1):
        for mv_idx in range(1,s_idx+1):
            if num_lst[mv_idx] < num_lst[s_idx]:
                dp[s_idx] = max(dp[mv_idx]+1,dp[s_idx])
    return N - max(dp)

N = int(input())
num_lst = [1]
for _ in range(N):
    num_lst.append(int(input()))
print(sol())
