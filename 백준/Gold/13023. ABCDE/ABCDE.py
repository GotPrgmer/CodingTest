import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

def backtracking(node, cnt):
    global flag
    if cnt == 4:
        flag = 1
        return
    visited[node] = 1
    for i1 in graph[node]:
        if visited[i1]==0:
            visited[i1] = 1
            backtracking(i1, cnt+1)
            visited[i1] = 0

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
flag = 0
visited = [0 for _ in range(N+1)]
for i0 in range(N):

    backtracking(i0,0)
    visited[i0] = 0

    if flag == 1:
        print(1)
        break
if flag == 0:
    print(0)
