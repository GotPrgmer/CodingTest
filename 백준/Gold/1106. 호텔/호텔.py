import sys

def input():
    return sys.stdin.readline().rstrip()

C, N = map(int,input().split())

dp = [0 for _ in range(1000*101)]
increment = []
for _ in range(N):
    increment.append(list(map(int,input().split())))
increment.sort()


for i0 in range(len(dp)):
    for i1 in increment:
        if i0 >= i1[0]:
            dp[i0] = max(dp[i0],dp[i0-i1[0]]+i1[1])
        else:
            break
    if dp[i0] >= C:
        print(i0)
        break

