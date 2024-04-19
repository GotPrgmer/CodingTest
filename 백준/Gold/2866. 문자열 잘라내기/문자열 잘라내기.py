import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

R, C = map(int,input().split())
lst = ['' for _ in range(C)]
for _ in range(R):
    tmp = input()
    for e in range(C):
        lst[e] += tmp[e]

s = 0
e = R - 1
ans = 0
while s<=e:
    m = (s+e)//2
    visited = set()
    flag = 0
    for each_str in lst:
        tmp = each_str[m:]
        if tmp not in visited:
            visited.add(tmp)
        else:
            flag = 1
            break
    if flag == 0:
        s = m + 1
        ans = max(ans,m)
    else:
        e = m -1

print(ans)
