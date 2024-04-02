import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)


def bfs(r,c):
    # 두개 이상 인접한 같은 값일 경우 표시
    q = deque([])
    q.append((r,c))
    visited[r][c] = True # 한개라면 0으로 바꾸고 리턴
    #몇개가 일치하는지
    cnt = 1
    while q:
        cr,cc = q.pop()
        #네방향 %M 미방문, 값이 같으면, 범위내
        for d in range(4):
            nr,nc = cr+d_r[d], (cc+d_c[d])%M
            if 0<=nr<N and visited[nr][nc]==0 and arr[cr][cc] == arr[nr][nc]:
                q.append((nr,nc))
                visited[nr][nc] = True
                cnt += 1
    #인접한게 없음
    if cnt == 1:
        visited[r][c] = False







N, M, T = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]

for _ in range(T):
    x, d, k = map(int,input().split())
    for i in range(x-1,N,x):
        if d == 0:
            arr[i] = arr[i][-k:] + arr[i][:-k]
        else:
            arr[i] = arr[i][k:] + arr[i][:k]
    visited = [[False]*M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if visited[i][j] == False and arr[i][j] > 0:
                bfs(i,j) # i,j와 같은 인접한 값을 visited에 표시

    del_flag, sm, cnt=0,0,0
    for i in range(N):
        for j in range(M):
            if visited[i][j]:
                arr[i][j] = 0
                del_flag = 1
            else:
                if arr[i][j] > 0:
                    sm+= arr[i][j]
                    cnt += 1

    if del_flag == 0 and cnt > 0:
        avg = sm/cnt #분모값 0보다 큼
        for i in range(N):
            for j in range(M):
                if avg<arr[i][j]:
                    arr[i][j] -= 1
                elif 0<arr[i][j]<avg:
                    arr[i][j] += 1
    if sm == 0:
        break
print(sum(map(sum,arr)))