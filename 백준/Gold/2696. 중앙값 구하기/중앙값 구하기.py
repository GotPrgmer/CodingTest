import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    N = int(input())
    input_lst = []
    for _ in range(N//10+1):
        input_lst.extend(list(map(int,input().split())))
    q = []
    ans = []
    print((N+1)//2)
    for i0 in range(N):
        q.append(input_lst[i0])

        q.sort()
        if (i0+1)%2 == 1:
            ans.append(q[len(q)//2])
    print(*ans)

