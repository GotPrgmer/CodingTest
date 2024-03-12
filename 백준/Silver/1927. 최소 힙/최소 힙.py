import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

q = []
for _ in range(N):
    x = int(input())

    if x != 0:
        heapq.heappush(q,x)
    else:
        if not q:
            print(0)
        else:
            print(heapq.heappop(q))
