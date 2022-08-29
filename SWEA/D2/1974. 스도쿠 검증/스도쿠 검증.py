T = int(input())

for tc in range(1, T + 1):
    board = [list(map(int,input().split())) for _ in range(9)]
    ans = 1
    ano_board = []
    tri_check = []


    #행 검사
    for i in range(9):
        if len(set(board[i])) != 9:
            ans = 0
            break
    ano_board = list(zip(*board))
    if ans != 0:
        #열 검사
        for j in range(9):
            if len(set(ano_board[j])) != 9:
                ans = 0
                break
    if ans != 0:
        #3x3검사
        for i in range(0,9,3):
            for j in range(0,9,3):
                for row in range(i,i+3):
                    for col in range(j,j+3):
                        tri_check.append(board[row][col])
                if len(set(tri_check)) != 9:
                    ans = 0
                    break
                else:
                    tri_check = []
            if ans == 0 :
                break
    print(f'#{tc} {ans}')
