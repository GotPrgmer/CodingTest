import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
num_dict = defaultdict(list)
max_lst = [0]*N
min_lst = [0]*N
original_max_lst = [0]*N
original_min_lst = [0]*N

for i in range(N):
    a, b = map(int,input().split())
    min_lst[i]=(a-b)
    max_lst[i]=(a+b)

    original_min_lst[i] = min_lst[i]
    original_max_lst[i] = max_lst[i]

min_lst.sort()
max_lst.sort()
for i in range(N):
    s = 0
    e = N
    while s<e:
        m = (s+e)//2
        if max_lst[m] >= original_min_lst[i]:
            e = m
        else:
            s = m + 1
    ans1 = e + 1

    s = 0
    e = N
    while s<e:
        m = (s+e)//2
        if min_lst[m] <= original_max_lst[i]:
            s = m+1
        else:
            e = m
    ans2 = e
    print(ans1, ans2)

