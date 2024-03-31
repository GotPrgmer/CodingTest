import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
q = []
for _ in range(N):
    heapq.heappush(q,int(input()))
ans = 0
while len(q)>=2:
    first = heapq.heappop(q)
    second = heapq.heappop(q)
    ans += first + second
    heapq.heappush(q,first+second)
    
print(ans)