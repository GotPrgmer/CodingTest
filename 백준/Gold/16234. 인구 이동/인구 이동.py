import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

d_r = (-1,0,1,0)
d_c = (0,1,0,-1)

N, L, R = map(int,input().split())

nations = deque([])

for _ in range(N):
    nations.append(list(map(int,input().split())))

#나라별 상하좌우 돌면서 인구 대이동 체크
#싹 다돌면서
#첨부터 싹 돌면서 계속확인
def bfs(row,col):
    global flag
    global sum_pop
    q = deque([(row,col)])

    while q:
        # global visited
        current = q.popleft()
        x = current[0]
        y = current[1]
        for d in range(4):
            if 0<= x+d_r[d] < N and 0<= y+d_c[d] < N:
                if (x + d_r[d], y + d_c[d]) not in nations_move and (x + d_r[d], y + d_c[d]) not in visited:
                    nr = x+d_r[d]
                    nc = y+d_c[d]
                    if L <= abs(nations[x][y] - nations[nr][nc]) <= R:
                        flag = 1
                        q.append((nr,nc))
                        nations_move.add((nr,nc))
                        visited.add((nr,nc))
                        sum_pop += nations[nr][nc]
                        if (row,col) not in nations_move:
                            nations_move.add((row,col))
                            visited.add((row,col))


# 모든 좌표를 다 탐색
# 탐색하면서 인구이동이 발생하는 지 체크
# 발생하게 되면 한 나라에서 국경을 열고 평균값으로 수치를 맞춤
# 한번이라도 인구이동이 발생하게 되면 처음부터 돌아가서 탐색
ans = 0
check_move = 1
while check_move:
    check_move = 0
    visited = set()
    #이번타임에 인구이동을 한 visited
    for r in range(N):
        for c in range(N):
            flag = 0
            ## 인구이동
            nations_move = set()
            sum_pop = nations[r][c]
            if (r,c) not in visited:
                bfs(r,c)
            #인구이동이 일어남
                if flag == 1:
                    check_move = 1
                    total_nations = len(nations_move)
                    for pop in nations_move:
                        nations[pop[0]][pop[1]] = sum_pop//total_nations

    if check_move == 1:
        ans += 1
        continue
print(ans)
