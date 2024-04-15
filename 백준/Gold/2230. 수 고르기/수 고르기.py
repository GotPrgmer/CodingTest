import sys

def input():
    return sys.stdin.readline().rstrip()

def check(mid):
    start = 0
    end = N-1
    while start<=end:
        if num_lst[end] - num_lst[start] > mid:
            end -= 1
        elif num_lst[end] - num_lst[start] == mid:
            return True
        else:
            start += 1
            end = N-1
    return False

N, M = map(int,input().split())

num_lst = []
for _ in range(N):
    num_lst.append(int(input()))

num_lst.sort()

start = 0
end = 0
ans = float('INF')
if N <=2:
    print(num_lst[-1]-num_lst[0])
else:
    while start <= end <= len(num_lst) - 1:

        # check
        if num_lst[end] - num_lst[start] < M:
            end += 1
        elif num_lst[end] - num_lst[start] >= M:
            if num_lst[end] - num_lst[start] < ans:
                ans = min(ans,num_lst[end] - num_lst[start])
            start += 1
    print(ans)



