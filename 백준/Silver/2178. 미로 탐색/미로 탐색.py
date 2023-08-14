import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)

N, M = map(int,input().split())

miro = []

for r in range(N):
    miro.append(list(map(int,input())))

q = deque([(0,0)])

visited = set()
visited.add((0,0))
ans = 999999
while q:
    cur_r, cur_c = q.popleft()
    for d in range(4):
        if 0<=cur_r+d_r[d]<N and 0<=cur_c+d_c[d]<M:
            nr = cur_r+d_r[d]
            nc = cur_c+d_c[d]

            if miro[nr][nc]!=0 and (nr,nc) not in visited:
                miro[nr][nc]=miro[cur_r][cur_c]+1
                q.append((nr,nc))
                visited.add((nr,nc))
            if (nr,nc) == (N-1,M-1):
                ans = min(ans,miro[nr][nc])
print(ans)
