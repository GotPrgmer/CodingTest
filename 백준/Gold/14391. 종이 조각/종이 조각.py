import sys

def input():
    return sys.stdin.readline().rstrip()

def bitmasking():
    global ans
    for case in range(1<<(N*M)):
        total = 0
        # 가로 합계
        for r in range(N):
            row_sum = 0
            for c in range(M):
                cur = r*M + c
                # 해당 case의 비트와 현재 위치의 비트가 일치하는걸 가로
                if case & ( 1<<cur) != 0:
                    # 기존값에서 10을 더해서 자릿수를 바꾸고 현재값을 더해줌
                    row_sum = row_sum*10 + board[r][c]
                else:
                    #total에 더하고
                    total += row_sum
                    row_sum = 0
            #세로를 만나지 않았을 경우도 있으니
            total += row_sum

        for c in range(M):
            col_sum = 0
            for r in range(N):
                cur = r*M + c
                # 해당 case 비트와 현재 비트가 안맞으면 세로
                if case & (1<<cur) == 0:
                    #기존값에서10을 곱하고 현재값을 더해줌
                    col_sum = col_sum*10 + board[r][c]
                else:
                    #total 더하기
                    total += col_sum
                    col_sum = 0
            total += col_sum
        ans = max(ans,total)

N, M = map(int,input().split())
board = []
for _ in range(N):
    board.append(list(map(int,input())))


ans = 0
bitmasking()
print(ans)
