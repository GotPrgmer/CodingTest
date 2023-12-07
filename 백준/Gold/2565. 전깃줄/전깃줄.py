import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
hq = []
line = dict()
#들어오는 라인 입력
for _ in range(N):
    x, y = map(int,input().split())
    line[x] = y
x_values = list(line.keys())
x_values.sort()
dp = [1 for _ in range(len(x_values))]
#증가하는 수열... 최장 증가 수열 LIS방식...?
for x in range(len(x_values)):
    #x보다 작은 값들을 넣어서 조건에 맞는지 보고 dp를 갱신!
    for b_x in range(x):
        if line[x_values[b_x]] < line[x_values[x]]:
            dp[x] = max(dp[x],dp[b_x] + 1)


print(N - max(dp))
