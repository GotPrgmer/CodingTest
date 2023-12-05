import sys
import heapq
from collections import deque

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)
def input():
    return sys.stdin.readline().rstrip()

N, M, oil = map(int,input().split())
#1: wall, 2: 승객, 3: taxi

#맵 정보 받기
map_info = [list(map(int,input().split())) for _ in range(N)]

#시작하는 행 번호와 열 번호
start_r, start_c = map(int,input().split())
start = [start_r-1,start_c - 1]

guest_info = dict()


for idx in range(1,M+1):
    g_r, g_c, desti_r, desti_c = map(int,input().split())
    guest_info[(g_r - 1, g_c - 1)] = (desti_r-1,desti_c-1)
    map_info[g_r - 1][g_c - 1] = 2

#거리재는 함수 BFS
def length_measure(start):
    heap = []
    q = deque()
    q.append(start)
    visited = [[-1 for i1 in range(N)] for i0 in range(N)]
    visited[start[0]][start[1]] = 0
    while q:
        r, c = q.popleft()

        #게스트가 있는 위치를 발견
        if map_info[r][c] == 2:
            heapq.heappush(heap,(visited[r][c], r, c))

        for idx in range(4):
            n_r = r + d_r[idx]
            n_c = c + d_c[idx]

            if (0 <= n_r < N and 0 <= n_c < N):
                if map_info[n_r][n_c] != 1 and visited[n_r][n_c] == -1:
                    visited[n_r][n_c] = visited[r][c] + 1
                    q.append((n_r,n_c))
    return heap

#가는데 드는 비용 계산
def taskOil(start, dest):
    r, c = start
    q = deque()
    q.append((r,c))
    visited = [[-1 for _ in range(N)] for _ in range(N)]
    visited[r][c] = 0
    while q:
        r, c = q.popleft()
        if dest == (r,c):
            return visited[r][c]
        for idx in range(4):
            n_r = r + d_r[idx]
            n_c = c + d_c[idx]
            if 0 <= n_r < N and 0 <= n_c < N:
                if map_info[n_r][n_c] != 1 and visited[n_r][n_c] == -1:
                    visited[n_r][n_c] = visited[r][c] + 1
                    q.append((n_r,n_c))
    return visited[dest[0]][dest[1]]

cnt = 0
while True:
    #어떤 손님을 태울까?
    guest_heap = length_measure(start)
    if len(guest_heap) == 0:
        break
    #이번에 태울 손님에게 가자!
    distance, r, c = heapq.heappop(guest_heap)
    oil -= distance
    if oil < 0:
        oil = -1
        break
    #목적지까지 태워주기 위해 손님 목적지 정보를 가져오기
    destination = guest_info[(r,c)]
    distance_to_dest = taskOil((r,c), destination)

    #목적지까지 도착할 수 없음
    if distance_to_dest == -1:
        oil = -1
        break
    #도착할 수 있지만 기름이 되는지 확인!
    else:
        #기름이 안돼요~~
        if oil < distance_to_dest:
            oil = -1
            break
        #기름 삽가능!
        #충전되는 기름은 가는데까지 걸린 비용! 근데 출발하기 전에 거리를 뺐으므로 이익은 목적지까지 거리
        else:
            oil += distance_to_dest

    map_info[r][c] = 0

    #목적지까지 갔으므로 택시 시작위치를 목적지 위치로 변경
    start = destination
    cnt += 1

if cnt < M:
    print(-1)
else:
    print(oil)