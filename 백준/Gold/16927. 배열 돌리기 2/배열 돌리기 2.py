import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

d_r = (1,0,-1,0)
d_c = (0,1,0,-1)

def sol():
    #외곽 먼저 돌리기
    #몇번 돌리는지 계산
    circuit = min(N,M) // 2
    #행렬 다 1차원으로 다 피기
    line_data = []
    for start_point in range(circuit):
        temp = deque([])
        r = start_point
        c = start_point
        for d in range(4):
            if not flag[r][c]:
                temp.append(data_set[r][c])
                flag[r][c] = True
            while 0 <= r < N and 0 <= c < M:
                if 0 <= r + d_r[d] < N and 0 <= c + d_c[d] < M:
                    if not flag[r + d_r[d]][c + d_c[d]]:
                        r += d_r[d]
                        c += d_c[d]
                        temp.append(data_set[r][c])
                        flag[r][c] = True


                    else:
                        break
                else:
                    break
            # 외곽 돌리기
        line_data.append(temp)

    # 각 라인들 앞빼고 뒤 넣기 R반복
    cycle = (N-1)*2+(M-1)*2
    for line in line_data:
        for _ in range(R%(cycle)):
            tmp_previous = line.pop()
            line.appendleft(tmp_previous)
        cycle -= 8

    for start_point in range(circuit):
        enitre_this_temp = line_data[start_point]
        r = start_point
        c = start_point
        for d in range(4):
            if flag[r][c]:
                data_set[r][c] = enitre_this_temp.popleft()
                flag[r][c] = False
            while 0 <= r < N and 0 <= c < M:
                if 0 <= r + d_r[d] < N and 0 <= c + d_c[d] < M:
                    if flag[r + d_r[d]][c + d_c[d]]:
                        r += d_r[d]
                        c += d_c[d]
                        data_set[r][c] = enitre_this_temp.popleft()
                        flag[r][c] = False

                    else:
                        break
                else:
                    break




    return data_set



N, M, R = map(int,input().split())

data_set = [list(map(int,input().split())) for _ in range(N)]
flag = [[False]*M for _ in range(N)]

ans = sol()
for ans_print in ans:
    print(*ans_print)