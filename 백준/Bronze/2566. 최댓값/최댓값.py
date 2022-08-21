input_matrix = [list((map(int,input().split()))) for _ in range(9)]
max_number = -1
max_row = -1
max_col = -1
for i in range(9):
    for j in range(9):
        if max_number < input_matrix[i][j]:
            max_number = input_matrix[i][j]
            max_row = i + 1
            max_col = j + 1
print(max_number)
print(max_row,max_col)