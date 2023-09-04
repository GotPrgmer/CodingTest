import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
timetable = []

for _ in range(N):
    s, e = map(int,input().split())
    timetable.append([s,e])

timetable.sort()
pq = []
heapq.heappush(pq,timetable[0][1])
#몇개의 교실로 시간표를 포괄할 수 있는지?
for i0 in range(1,N):
    if timetable[i0][0] >= pq[0]:
        #수업시간 변경
        heapq.heappop(pq)
        heapq.heappush(pq, timetable[i0][1])
        continue
    else:
        heapq.heappush(pq,timetable[i0][1])

print(len(pq))