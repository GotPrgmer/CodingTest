import sys
from collections import deque

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)
def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

glacier = [list(map(int,input().split())) for _ in range(N)]

def bfs(r,c):
    q = deque([(r,c)])
    visited[r][c] = 1
    tmp = []

    while q:
        r, c = q.popleft()
        water = 0
        for d in range(4):
            nr = r + d_r[d]
            nc = c + d_c[d]
            if 0 <= nr < N and 0 <= nc < M:
                if not glacier[nr][nc]:
                    water += 1
                elif glacier[nr][nc] and not visited[nr][nc]:
                    q.append((nr,nc))
                    visited[nr][nc] = 1
        if water > 0:
            tmp.append((r,c,water))
    for r, c, water in tmp:
        glacier[r][c] = max(0,glacier[r][c] - water)

    return 1






#0이 아닌 부분 좌표로 넣기

#0이 아닌 것들 좌표에 넣기
points = []
for r in range(N):
    for c in range(M):
        if glacier[r][c]:
            points.append((r,c))

ans = 0

year = 0
while points:
    visited = [[0] * M for _ in range(N)]
    candidate = []
    cnt = 0
    for r, c in points:
        if glacier[r][c] and not visited[r][c]:
            cnt += bfs(r,c)
        if not glacier[r][c]:
            candidate.append((r,c))

    if cnt > 1:
        print(year)
        break
    points = list(set(points) - set(candidate))
    year += 1
if cnt < 2:
    print(0)
