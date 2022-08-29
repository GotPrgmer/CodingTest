T = int(input())

for tc in range(1, T + 1):
    N, M = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(N)]
    max_flies = 0
    temp1 = 0
    temp2 = 0

    #+
    d_r = [-1,0,1,0]
    d_c = [0,1,0,-1]

    #x
    d_xr = [-1,1,1,-1]
    d_xc = [1,1,-1,-1]

    # 각 칸에서 + x자로 합계 구해서 최대값 갱신
    for i in range(N):
        for j in range(N):
            temp1 = board[i][j]
            temp2 = board[i][j]
            for d in range(4):
                for k in range(1,M):
                    if 0 <= i+d_r[d]*k < N and 0 <= j+d_c[d]*k < N:
                        temp1 += board[i+d_r[d]*k][j+d_c[d]*k]

                for k in range(1, M):
                    if 0 <= i + d_xr[d]*k < N and 0 <= j + d_xc[d]*k < N:
                        temp2 += board[i + d_xr[d]*k][j + d_xc[d]*k]

            if temp1<temp2:
                if max_flies<temp2:
                    max_flies = temp2
            else:
                if max_flies<temp1:
                    max_flies = temp1
    print(f'#{tc} {max_flies}')
