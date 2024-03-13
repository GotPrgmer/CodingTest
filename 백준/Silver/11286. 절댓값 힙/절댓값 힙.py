import sys

import heapq
def input():
    return sys.stdin.readline().rstrip()

N = int(input())

q = []
for _ in range(N):
    input_num = int(input())
    if input_num != 0:
        heapq.heappush(q,(abs(input_num),input_num))
    else:
        if q:
            print(heapq.heappop(q)[1])
        else:
            print(0)
