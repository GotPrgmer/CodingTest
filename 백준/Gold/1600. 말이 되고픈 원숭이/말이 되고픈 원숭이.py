import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = [-1,0,1,0]
d_c = [0,1,0,-1]

h_r = [-2,-2,-1,1,2,2,1,-1]
h_c = [-1,1,2,2,1,-1,-2,-2]

K = int(input())
W, H = map(int,input().split())
map_info = [list(map(int,input().split())) for _ in range(H)]

q = deque([])
visited = [[[0]*(K+1) for _ in range(W)] for _ in range(H)]
#r, c, 말처럼 이동한 횟수
q.append([0,0,0])
visited[0][0][0] = 1
def bfs():
    while q:
        x, y, z = q.popleft()
        #목표지점 도달
        if x == H - 1 and y == W - 1:
            return visited[x][y][z] - 1

        # 델타 탐색
        for delta in range(4):
            nx = x + d_r[delta]
            ny = y + d_c[delta]

            if 0<=nx<H and 0<=ny<W and not visited[nx][ny][z] and not map_info[nx][ny]:
                visited[nx][ny][z] = visited[x][y][z] + 1
                q.append([nx,ny,z])

        if z < K:
            for horse_delta in range(8):
                hx = x + h_r[horse_delta]
                hy = y + h_c[horse_delta]
                if 0<=hx<H and 0<=hy<W:
                    if not map_info[hx][hy]:
                        if not visited[hx][hy][z+1]:
                            visited[hx][hy][z+1] = visited[x][y][z] + 1
                            q.append([hx,hy,z+1])

    return -1
print(bfs())