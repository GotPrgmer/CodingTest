import sys
sys.setrecursionlimit(10000)
from collections import deque
def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

graph = [[0]*(N) for _ in range(N)]
for _ in range(M):
    input_r, input_c = map(int,input().split())
    graph[input_r-1][input_c-1] = 1
    graph[input_c-1][input_r-1] = 1

stack = deque([])
ans = 0
def dfs(node):
    global ans
    visited.add(node)


    for dest in range(len(graph[node])):
        if graph[node][dest] == 1 and dest not in visited:
            dfs(dest)
    else:
        return

visited = set()

for i in range(N):
    if i not in visited:
        ans += 1
        dfs(i)

print(ans)


