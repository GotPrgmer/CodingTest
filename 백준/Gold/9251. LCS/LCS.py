import sys

def input():
    return sys.stdin.readline().rstrip()

A = input()
B = input()

dp = list([0 for _ in range(len(B)+1)] for _ in range(len(A)+1))

for r in range(1,len(A)+1):
    for c in range(1,len(B)+1):
        if A[r-1] == B[c-1]:
            dp[r][c] = dp[r-1][c-1]+1
        else:
            dp[r][c] = max(dp[r][c-1],dp[r-1][c])
print(dp[len(A)][len(B)])