import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0,0,0)
d_c = (0,1,0,-1,0,0)
d_h = (0,0,0,0,1,-1)

M, N, H = map(int,input().split())

box = [[] for _ in range(H)]
q = deque([])
zero_cnt = 0
one_cnt = 0
for h in range(H):
    for r in range(N):
        this_tomato = list(map(int,input().split()))
        zero_cnt += len(list(filter(lambda x: x == 0,this_tomato)))
        box[h].append(this_tomato)
        for c in range(M):
            if box[h][r][c] == 1:
                q.append((h,r,c))

one_cnt = len(q)
ans = 1
access_cnt = 0

if zero_cnt == 0:
    print(0)
else:
    while q:
        h,r,c= q.popleft()
        for d in range(6):
            if 0<=r+d_r[d]<N and 0 <=c+d_c[d]<M and 0 <=h+d_h[d]<H:
                nr = r+d_r[d]
                nc = c+d_c[d]
                nh = h+d_h[d]
                if box[nh][nr][nc] == 0:
                    box[nh][nr][nc] = box[h][r][c] + 1
                    q.append((nh,nr,nc))
                    ans = max(ans,box[nh][nr][nc])
                    access_cnt += 1
    if zero_cnt == access_cnt:
        print(ans-1)
    else:
        print(-1)

