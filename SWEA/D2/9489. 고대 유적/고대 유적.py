T = int(input())

for tc in range(1, T + 1):
    N, M = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(N)]
    max_excavate = 0
    ex = 0


    for i in range(0, N):
        for j in range(0, M):
            if board[i][j] == 1:
                ex += 1
            else:
                if max_excavate < ex :
                    max_excavate = ex
                ex = 0
        if max_excavate < ex:
            max_excavate = ex
        ex = 0

    board = list(zip(*board))

    for i in range(0,M):
        for j in range(0,N):
            if board[i][j] == 1:
                ex += 1
            else:
                if max_excavate < ex :
                    max_excavate = ex
                ex = 0
        if max_excavate < ex:
            max_excavate = ex
        ex = 0
    print(f'#{tc} {max_excavate}')

