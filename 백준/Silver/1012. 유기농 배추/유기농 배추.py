import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)
T = int(input())

for _ in range(T):
    M, N,K = map(int,input().split())
    batchu = [[0]*M for _ in range(N) ]
    for _ in range(K):
        c, r = map(int,input().split())
        batchu[r][c] = 1
    visited = set()
    ans = 0
    for r in range(N):
        for c in range(M):
            if batchu[r][c] == 1 and (r,c) not in visited:
                ans += 1
                stack = deque([(r,c)])
                visited.add((r,c))
                while stack:
                    cur_r,cur_c = stack.pop()
                    for d in range(4):
                        if 0<=cur_r+d_r[d]<N and 0<=cur_c+d_c[d]<M and (cur_r+d_r[d],cur_c+d_c[d]) not in visited:
                            nr = cur_r+d_r[d]
                            nc = cur_c+d_c[d]
                            if batchu[nr][nc] == 1:
                                stack.append((nr,nc))
                                visited.add((nr,nc))
    print(ans)
