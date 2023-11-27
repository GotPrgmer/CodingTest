import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
crane_weight = list(map(int,input().split()))
crane_weight.sort(reverse=True)

M = int(input())
box_weight = list(map(int,input().split()))
box_weight.sort(reverse=True)

if crane_weight[0] < box_weight[0]:
    print(-1)
else:
    t = 0
    while box_weight:
        for weight in crane_weight:
            for i0 in range(len(box_weight)):
                if weight >= box_weight[i0]:
                    box_weight.remove(box_weight[i0])
                    break
        t += 1
    print(t)
