import sys
from collections import deque

input = sys.stdin.readline
line = int(input())
lst = deque()

for i in range(line):
    cmmd = input().split()
    if cmmd[0]=='pop':
        if len(lst):
            print(lst.pop())
        else:
            print(-1)
    elif cmmd[0]=='size':
        print(len(lst))
    elif cmmd[0]=='empty':
        if len(lst)==0:
            print(1)
        else:
            print(0)
    elif cmmd[0]=='front':
        if len(lst)>0:
            print(lst[-1])
        else:
            print(-1)
    elif cmmd[0]=='back':
        if len(lst)>0:
            print(lst[0])
        else:
            print(-1)
    elif cmmd[0]=='push':
        lst.insert(0,cmmd[1])