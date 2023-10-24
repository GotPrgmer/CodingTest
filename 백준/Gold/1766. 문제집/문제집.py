import sys
import heapq
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
q = []
relation = [[] for _ in range(N+1)]
node_dict = defaultdict(int)
for _ in range(M):


    first, second = map(int,input().split())
    relation[first].append(second)

    #위상정렬을 낮은 것부터 넣기
    #위상 초기세팅
    node_dict[second] += 1
for i1 in range(1,N+1):
    if not node_dict[i1]:
        heapq.heappush(q,i1)
for i0 in range(len(relation)):
    relation[i0].sort()
result = []
#위상정렬 시작
while q:
    cur = heapq.heappop(q)
    result.append(cur)
    for i2 in relation[cur]:
        node_dict[i2] -= 1
        if not node_dict[i2]:
            heapq.heappush(q, i2)

print(*result)
