import sys
import heapq
from collections import defaultdict
def input():
    return sys.stdin.readline().rstrip()

N = int(input())
cnt = defaultdict(int)
for _ in range(N):
    cnt[int(input())] += 1
q = []
for i in cnt.keys():
    heapq.heappush(q,(-cnt[i],i))
print(heapq.heappop(q)[1])