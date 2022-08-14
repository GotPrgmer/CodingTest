entire_square = [[0]*1001 for _ in range(1001)]
ans = 0

T = int(input())
for number in range(T):
    start_row, start_col , row_number, col_number = map(int,input().split())
    for i in range(start_row, start_row+row_number):
        for j in range(start_col,start_col + col_number):
            entire_square[i][j] = number + 1

for number in range(T):
    ans = 0
    for row in range(1001):
        for col in range(1001):
            if entire_square[row][col] == number + 1:
                ans += 1
    print(ans)


