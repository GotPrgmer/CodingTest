import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def sol():
    tmp = 0
    for cur in humans:
        loc, human = cur
        tmp += human
        if tmp >= (total_human // 2) +1:
            return loc





N = int(input())

humans= []
total_human = 0
ans = 0
for i in range(1,N+1):
    loc, num_human = map(int,input().split())
    humans.append((loc,num_human))
    total_human += num_human
humans.sort()
print(sol())

