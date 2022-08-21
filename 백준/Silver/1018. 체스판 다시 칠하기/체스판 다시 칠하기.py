N,M = map(int,input().split())

input_matrix = [list(map(str,input())) for _ in range(N)]
d_row = [0,1,0,1]
d_col = [1,0,-1,0]
x = 1
y = 1
direction = 0
painting_cnt = 0
min_times = N*M + 1


for i in range(0,N-8+1):
    new_matrix = []
    for j in range(0,M-8+1):
        new_matrix = [[0]+input_matrix[i][j:j+8]+[0], [0]+input_matrix[i+1][j:j+8]+[0], [0]+input_matrix[i+2][j:j+8]+[0], [0]+input_matrix[i+3][j:j+8]+[0], [0]+input_matrix[i+4][j:j+8]+[0], [0]+input_matrix[i+5][j:j+8]+[0], [0]+input_matrix[i+6][j:j+8]+[0], [0]+input_matrix[i+7][j:j+8]+[0]]
        new_matrix = [[0]*(10)] + new_matrix + [[0]*(10)]

        x = 1
        y = 1
        direction = 0
        painting_cnt = 0
        for k in range(64):

            if (x + y) % 2 == 0 and new_matrix[x][y] != 'W':
                painting_cnt += 1
            elif (x + y) % 2 == 1 and new_matrix[x][y] != 'B':
                painting_cnt += 1
            if k == 63:
                break
            else:

                if new_matrix[x + d_row[direction]][y + d_col[direction]] == 0:
                    direction = (direction + 1) % 4
                    x += d_row[direction]
                    y += d_col[direction]
                    direction = (direction + 1) % 4

                else:

                    x += d_row[direction]
                    y += d_col[direction]

        if min_times > painting_cnt:
            min_times = painting_cnt

        x = 1
        y = 1
        direction = 0
        painting_cnt = 0

        for k in range(64):

            if (x + y) % 2 == 0 and new_matrix[x][y] != 'B':
                painting_cnt += 1
            elif (x + y) % 2 == 1 and new_matrix[x][y] != 'W':
                painting_cnt += 1

            if k == 64-1:
                break
            else:

                if new_matrix[x + d_row[direction]][y + d_col[direction]] == 0:
                    direction = (direction + 1) % 4
                    x += d_row[direction]
                    y += d_col[direction]
                    direction = (direction + 1) % 4

                else:

                    x += d_row[direction]
                    y += d_col[direction]
        if min_times > painting_cnt:
            min_times = painting_cnt
        painting_cnt = 0

print(min_times)