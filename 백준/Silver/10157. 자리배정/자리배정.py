#C는 가로 R은 세로
C, R = map(int,input().split())
K = int(input())

direction = 0
row_dict = [0,1,0,-1]
col_dict = [1,0,-1,0]

square_matrix = [[0]*(R+2)] + [[0]+ [-1]*R + [0] for _ in range(C)] + [[0]*(R+2)]
Number = 1
x = 1
y = 1
if K <= C * R:
    for i in range(K):
        square_matrix[x][y] = 1

        if i+1 != K and (square_matrix[x+row_dict[direction]][y+col_dict[direction]] == 0 or square_matrix[x+row_dict[direction]][y+col_dict[direction]] == 1):
            direction = (direction+ 1) % 4
            x += row_dict[direction]
            y += col_dict[direction]
        elif i+1 == K:
            break
        else:
            x += row_dict[direction]
            y += col_dict[direction]

    print(x,y)
else:
    print(0)