entire_square = [[0]*100 for _ in range(100)]
ans = 0

T = int(input())
for number in range(T):
    start_row, start_col= map(int,input().split())
		#한변이 10으로 정해져있으므로 주어진 row,col에 10을 더해준다.
    for i in range(start_row, start_row + 10):
        for j in range(start_col,start_col + 10):
						#한번이라도 색종이가 위치한 곳이면 1을 저장
            entire_square[i][j] = 1

#for number in range(T):
ans = 0
for row in range(100):
    for col in range(100):
        if entire_square[row][col] ==1:
            ans += 1
print(ans)