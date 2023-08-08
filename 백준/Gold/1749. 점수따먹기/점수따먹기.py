import sys

def input():
    return sys.stdin.readline().rstrip()
N, M = map(int,input().split())

arr = []
sum_arr = []

for t in range(N+1):
    if t != N:
        arr.append(list(map(int, input().split())))
    sum_arr.append([0] * (M + 1))
    if t >= 1:
        for j in range(1,M+1):
            sum_arr[t][j] = arr[t-1][j-1]+sum_arr[t-1][j] + sum_arr[t][j-1] - sum_arr[t-1][j-1]




ans = -999999
for r0 in range(N):
    for c0 in range(M):
        for r1 in range(r0,N):
            for c1 in range(c0,M):
                ans = max(ans,sum_arr[r1 + 1][c1 + 1] - sum_arr[r0][c1 + 1] - sum_arr[r1 + 1][c0] + sum_arr[r0][c0])
print(ans)