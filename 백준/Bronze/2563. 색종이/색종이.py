entire_square = [[0]*100 for _ in range(100)]
ans = 0

T = int(input())
for number in range(T):
    start_row, start_col= map(int,input().split())
    for i in range(start_row, start_row + 10):
        for j in range(start_col,start_col + 10):
            entire_square[i][j] = 1

for number in range(T):
    ans = 0
    for row in range(100):
        for col in range(100):
            if entire_square[row][col] ==1:
                ans += 1
print(ans)


