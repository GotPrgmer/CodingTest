def check_bingo(game_square):
    cnt = 0
    diagonal = 0
    for i in range(5):
        if sum(game_square[i]) == 0:
            cnt += 1
    transposed_matrix = list(zip(*game_square))
    for i in range(5):
        if sum(transposed_matrix[i]) == 0:
            cnt += 1

    for i in range(5):
        if game_square[i][i] == 0:
            diagonal += 1
    if diagonal == 5:
        cnt += 1
    diagonal = 0
    for i in range(5):
        if game_square[i][4-i] == 0:
            diagonal += 1
    if diagonal == 5:
        cnt += 1
    return cnt





stop = False
game_square = []
which_is_what_i_want = []
ans = 0
finish = 0

for _ in range(5):
    game_square.append(list(map(int,input().split())))
for _ in range(5):
    which_is_what_i_want.append(list(map(int,input().split())))
check_bingo(game_square)
for bingo_row in range(5):
    for bingo_col in range(5):
        stop = False
        for i in range(5):
            for j in range(5):
                if which_is_what_i_want[bingo_row][bingo_col] == game_square[i][j]:
                    game_square[i][j] = 0
                    ans += 1
                    stop = True
                    break
            if stop == True:
                break
        if check_bingo(game_square) >= 3:
            finish = 1
            break
    if finish == 1:
        print(ans)
        break


