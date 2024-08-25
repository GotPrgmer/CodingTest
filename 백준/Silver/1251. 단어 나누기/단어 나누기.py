import heapq
import sys
def input():
    return sys.stdin.readline().rstrip()
q =[]
n= list(input())
for i in range(1,len(n)-2):
    for j in range(i,len(n)-1):
        #세부분 각각 뒤집고 합쳐셔 힙q에 넣기
        first = ''.join(reversed(n[:i]))
        second = ''.join(reversed(n[i:j+1]))
        third = ''.join(reversed(n[j+1:]))
        total = first+second+third
        heapq.heappush(q,total)
print(q[0])
