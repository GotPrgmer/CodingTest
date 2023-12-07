import bisect
import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
lst = list(map(int,input().split()))
dp = [lst[0]]

#현재 위치를 픽스시키고 과거의 항들을 조사해서 낮은 것들만 더함
for e in range(N):
    #마지막 항보다 크다면?
    if dp[-1] < lst[e]:
        dp.append(lst[e])
    #현재 수열 안으로 들어갈래요
    else:
        idx = bisect.bisect_left(dp,lst[e])
        dp[idx] = lst[e]


print(len(dp))