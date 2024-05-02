import sys

def input():
    return sys.stdin.readline().rstrip()

K, N = map(int,input().split())
lst = []
for _ in range(K):
    lst.append(int(input()))

s = 1
e = max(lst)
ans = 0
while s <= e:
    m = (s+e)//2

    #check
    cnt = 0
    for i in lst:
        cnt += i//m
    # print(cnt,m)

    #N보다 많으면 길이를 늘려함
    if cnt >= N:
        ans = max(ans,m)
        s = m + 1
    #N보다 적으면 길이를 줄여야함
    elif cnt < N:
        e = m - 1


print(ans)
