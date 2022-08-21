input_matrix = [[0]*10] + [[0]+list(map(str,input()))+[0] for _ in range(8)] + [[0]*10]
d_row = [0,1,0,1]
d_col = [1,0,-1,0]
x = 1
y = 1
direction = 0
sum_horse = 0

for i in range(64):

    if (x + y) % 2 == 0 and input_matrix[x][y] == 'F':
        sum_horse += 1
    if i == 63:
        break
    else:

        if input_matrix[x + d_row[direction]][y + d_col[direction]] == 0:
            direction = (direction + 1) % 4
            x += d_row[direction]
            y += d_col[direction]
            direction = (direction + 1) % 4

        else:

            x += d_row[direction]
            y += d_col[direction]

print(sum_horse)

