entire_square = [[0]*101 for _ in range(101)]
ans = 0
cnt = 0

for _ in range(4):
    start_row, start_col , end_row, end_col = map(int,input().split())
    for i in range(start_col, start_col+abs(start_col-end_col)):
        for j in range(start_row,start_row+abs(start_row-end_row)):
            entire_square[i][j] = 1
            cnt += 1
for result_sum in range(len(entire_square)):
    ans += sum(entire_square[result_sum])
print(ans)

