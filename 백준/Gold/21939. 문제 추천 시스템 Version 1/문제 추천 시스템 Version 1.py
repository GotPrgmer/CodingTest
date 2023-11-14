import sys
from collections import deque
import heapq

def input():
    return sys.stdin.readline().rstrip()

def recommend(x):
    if x == 1:
        while not visited[-maxheap[0][1]]:
            heapq.heappop(maxheap)
        print(-maxheap[0][1])
    else:
        while not visited[minheap[0][1]]:
            heapq.heappop(minheap)
        print(minheap[0][1])

def add(P,L):
    while not visited[minheap[0][1]]:
        heapq.heappop(minheap)
    while not visited[-maxheap[0][1]]:
        heapq.heappop(maxheap)
    visited[P] = True
    heapq.heappush(minheap,[L,P])
    heapq.heappush(maxheap,[-L,-P])

def solved(P):
    visited[P] = False


N = int(input())
minheap = []
maxheap = []

visited = {}

for _ in range(N):
    P, L = map(int,input().split())
    heapq.heappush(minheap,[L,P])
    heapq.heappush(maxheap,[-L,-P])
    visited[P] = True

M = int(input())

for _ in range(M):
    cmd_lst = list(map(str,input().split()))

    if cmd_lst[0] == 'add':
        add(int(cmd_lst[1]),int(cmd_lst[2]))

    elif cmd_lst[0] == 'recommend':
        recommend(int(cmd_lst[1]))

    else:
        solved(int(cmd_lst[1]))
