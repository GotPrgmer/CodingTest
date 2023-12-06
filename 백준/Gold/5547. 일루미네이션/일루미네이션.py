import sys
from collections import deque




#아래, 대각선 오른쪽, 오른쪽
odd_d_r = (1,1,0)
odd_d_c = (0,1,1)
#아래, 대각선 왼쪽, 오른쪽
even_d_r = (1,1,0)
even_d_c = (0,-1,1)

def input():
    return sys.stdin.readline().rstrip()

W, H = map(int,input().split())
house = [list(map(int,input().split())) for _ in range(H)]


#뚫려있는 부분을 전부 -1로 바꾸기
def flood(start):
    q = deque([start])
    house[start[0]][start[1]] = -1

    while q:
        cur = q.popleft()
        for d in [(-1,0),(0,-1),(1,0),(0,1),(-1,1),(1,1)]:
            #범위체크
            if d == (-1,1) or d == (1,1):
                #여기서는 홀수이냐? (문제에서는 짝수의 경우)
                if cur[0] % 2 != 0:
                    d = (-d[0],-d[1])

            if 0 <= cur[0] + d[0] < H and 0 <= cur[1] + d[1] < W:
                    n_r = cur[0] + d[0]
                    n_c = cur[1] + d[1]
                    if house[n_r][n_c] == 0:
                        #큐 중복이 일어나지 않게 방문처리
                        house[n_r][n_c] = -1
                        visited.add((n_r,n_c))
                        q.append((n_r,n_c))

#좌표 하나당 홀수 짝수 파악해서 3갈래로 가면서 2씩 빼준다.
def count_edges(start):
    global node_num
    global cnt_sub
    q = deque([start])

    while q:
        cur = q.popleft()
        visited.add(cur)
        for d in [(1,0),(1,1),(0,1)]:
            if d == (1,1):
                #문제상으로 홀수
                if cur[0] % 2 != 0:
                    d = (d[0],-d[1])

            if 0 <= cur[0] + d[0] < H and 0 <= cur[1] + d[1] < W:
                n_r = cur[0] + d[0]
                n_c = cur[1] + d[1]
                if house[n_r][n_c] != -1:
                    # 큐 중복이 일어나지 않게 방문처리
                    cnt_sub -= 2
                    if (n_r, n_c) not in visited:
                        # 큐 중복이 일어나지 않게 방문처리
                        q.append((n_r, n_c))
                        visited.add((n_r, n_c))





cnt_sub = 0
visited = set()


for r in range(H):
    if r == 0 or r == H - 1 :
        for c in range(W):
            if house[r][c] == 0:
                flood((r,c))
                visited.add((r, c))
    else:
        if house[r][0] == 0:
            flood((r,0))
            visited.add((r, 0))
        if house[r][W-1] == 0:
            flood((r,W-1))
            visited.add((r, W - 1))

node_num = W*H - len(visited)
for r in range(H):
    for c in range(W):
        if (r,c) not in visited:
            count_edges((r,c))
            visited.add((r,c))

print(node_num*6 + cnt_sub)
