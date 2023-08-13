import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)

## dfs 재귀
## bfs 재귀

## nqueen문제
M, N = map(int,input().split())

box = [list(map(int,input().split())) for _ in range(N)]
visited = set()
start = tuple()

q = deque([])
cnt = 0
one_cnt = 0
for r in range(N):
    for c in range(M):
        if box[r][c] == 1:
            q.append((r,c))
            visited.add((r,c))
            box[r][c] = 0
            one_cnt += 1
        elif box[r][c] == 0:
            cnt += 1


ans = 0
if cnt != 0:
    while q:
        current = q.popleft()

        for d in range(4):
            if (0<= current[0] + d_r[d]<N and 0<=current[1] + d_c[d]<M) and ((current[0] + d_r[d],current[1] + d_c[d]) not in visited):

                nr = current[0] + d_r[d]
                nc = current[1] + d_c[d]
                if box[nr][nc] == 0:
                    box[nr][nc] = box[current[0]][current[1]]+ 1
                    ans = box[nr][nc]
                    visited.add((nr, nc))
                    q.append((nr, nc))
                else:
                    continue

    if len(visited)- one_cnt == cnt :
        print(ans)
    else:
        print(-1)
else:
    print(0)

