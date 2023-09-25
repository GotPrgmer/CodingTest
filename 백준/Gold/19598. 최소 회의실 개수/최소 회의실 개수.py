import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
time = []
#시작점부터 끝점까지 모두 1을 더해주고 마지막에서 -1을 해준다
for _ in range(N):
    s, e = map(int,input().split())
    time.append((s,e))

time.sort()

pq = []
heapq.heappush(pq,time[0][-1])

for classTime in range(1,len(time)):
    if pq[0] > time[classTime][0]:
        heapq.heappush(pq,time[classTime][-1])
    else:
        heapq.heappop(pq)
        heapq.heappush(pq,time[classTime][-1])
print(len(pq))






