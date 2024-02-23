# 왼쪽부터 오른쪽 그리고
# 위에서 아래로 차례대로 도는 느낌으로 가자

# 회색 타일을 발견하면 위 아래를 확인하고 위 아래 인덱스가 true이면 오른쪽으로 가서
# 또 확인 그리고 다음 타일로 넘어가기

import sys
def input():
    return sys.stdin.readline().rstrip()

# 가로 탐색
def row_search(row,col):
    wall = 0
    for r in range(row):
        up = 0
        for c in range(col):
            #벽일 때 시작
            if board[r][c] == "X":
                if up:
                    #위 스캔
                    if 0 <= r - 1 < row and 0 <= c < col:
                        nr = r - 1
                        nc = c
                        #투명벽
                        if board[nr][nc] == ".":
                            up += 1
                        else:
                            # .이 아닐 경우 0으로 초기화
                            up = 0
                            continue
                    #영역 못 갈 경우 0으로 초기화
                    else:
                        up = 0
                        continue
                    if up == 2:
                        wall += 1
                        up = 0
                else:
                    # 위 스캔
                    if 0 <= r - 1 < row and 0 <= c < col:
                        nr = r - 1
                        nc = c
                        if board[nr][nc] == ".":
                            up += 1
                        else:
                            continue
            else:
                up = 0
                continue

    for r in range(row):
        down = 0
        for c in range(col):
            if board[r][c] == "X":
                if down:
                    # 아래 스캔
                    if 0 <= r + 1 < row and 0 <= c < col:
                        nr = r + 1
                        nc = c
                        # 투명벽
                        if board[nr][nc] == ".":
                            down += 1
                        else:
                            # .이 아닐 경우 0으로 초기화
                            down = 0
                            continue
                    # 영역 못 갈 경우 0으로 초기화
                    else:
                        down = 0
                        continue
                    if down == 2:
                        wall += 1
                        down = 0

                else:
                    # 아래 스캔
                    if 0 <= r + 1 < row and 0 <= c < col:
                        nr = r + 1
                        nc = c
                        if board[nr][nc] == ".":
                            down += 1
                        else:
                            continue
            else:
                down = 0
                continue
    return wall




# 세로 탐색
def col_search(row,col):
    wall = 0
    for c in range(col):
        left = 0
        for r in range(row):
            # 벽일 때 시작
            if board[r][c] == "X":
                if left:
                    # 위 스캔
                    if 0 <= r < row and 0 <= c - 1 < col:
                        nr = r
                        nc = c - 1
                        # 투명벽
                        if board[nr][nc] == ".":
                            left += 1
                        else:
                            # .이 아닐 경우 0으로 초기화
                            left = 0
                            continue
                    # 영역 못 갈 경우 0으로 초기화
                    else:
                        left = 0
                        continue
                    if left == 2:
                        wall += 1
                        left = 0
                else:
                    # 위 스캔
                    if 0 <= r < row and 0 <= c - 1 < col:
                        nr = r
                        nc = c - 1
                        if board[nr][nc] == ".":
                            left += 1
                        else:
                            continue
            else:
                left = 0
                continue

    for c in range(col):
        right = 0
        for r in range(row):
            # 벽일 때 시작
            if board[r][c] == "X":
                if right:
                    # 위 스캔
                    if 0 <= r < row and 0 <= c + 1 < col:
                        nr = r
                        nc = c + 1
                        # 투명벽
                        if board[nr][nc] == ".":
                            right += 1
                        else:
                            # .이 아닐 경우 0으로 초기화
                            right = 0
                            continue
                    # 영역 못 갈 경우 0으로 초기화
                    else:
                        right = 0
                        continue
                    if right == 2:
                        wall += 1
                        right = 0
                else:
                    # 위 스캔
                    if 0 <= r < row and 0 <= c + 1 < col:
                        nr = r
                        nc = c + 1
                        if board[nr][nc] == ".":
                            right += 1
                        else:
                            continue
            else:
                right = 0
                continue
    return wall

#가로의 행 수 M, 새로의 열 수 N
M, N = map(int,input().split())

board = [list(input()) for _ in range(M)]

print(row_search(M,N) + col_search(M,N))

