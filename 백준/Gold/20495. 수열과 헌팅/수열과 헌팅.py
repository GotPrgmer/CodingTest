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
    s = -1
    e = N
    while s+1<e:
        m = (s+e)//2
        if max_lst[m] < original_min_lst[i]:
            s = m
        #값이 같거나 클때 T
        #T가 시작되는 위치를 찾아야함!
        #그런데 그 위치가 0이 될수도 있으니 나온 값에서 +1을 해준다.
        else:
            e = m
    ans1 = e
    s = -1
    e = N
    while s+1<e:
        m = (s+e)//2
        if min_lst[m] <= original_max_lst[i]:
            s = m
        #값이 클때가 F이므로
        #F가 시작되는 위치를 찾아야함!
        #구조상 0번째가 될수없기에 위와같이 +1을 해주지는 않는다.
        else:
            e = m
    ans2 = e
    print(ans1+1, ans2)

