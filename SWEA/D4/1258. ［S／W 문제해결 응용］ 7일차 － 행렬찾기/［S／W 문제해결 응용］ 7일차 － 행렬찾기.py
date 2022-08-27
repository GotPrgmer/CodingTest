T = int(input())

for tc in range(1, T + 1):
    big = int(input())
    matrix = [[0]*(big+2)] + [[0] + list(map(int,input().split())) +[0] for _ in range(big)] + [[0]*(big+2)]
    d_r = [0,1]
    d_c = [1,0]
    direction = 0
    flag = 0
    row_cnt = 0
    col_cnt = 0
    ans_list = []
    ans = []
    for row in range(1,big+1):
        for col in range(1,big+1):
            row_cnt = 0
            col_cnt = 0
            direction = 0
            if matrix[row][col] != 0 and ((matrix[row-1][col] == 0) and (matrix[row][col-1] == 0)):
                s_row = row
                s_col = col
                row_cnt = 1
                col_cnt = 1
                while matrix[s_row][s_col]:
                    #다음 칸이 0이 아니 cnt증가
                    if matrix[s_row+d_r[direction]][s_col+d_c[direction]]:
                        s_row += d_r[direction]
                        s_col += d_c[direction]
                        col_cnt += 1
                    else:
                        break
                direction += 1
                while matrix[s_row][s_col]:
                    #다음 칸이 0이 아니 cnt증가
                    if matrix[s_row+d_r[direction]][s_col+d_c[direction]]:
                        s_row += d_r[direction]
                        s_col += d_c[direction]
                        row_cnt += 1
                    else:
                        break
                ans_list.append([(row_cnt,col_cnt),row_cnt*col_cnt])
            else:
                continue
    ans_list.sort(key=lambda x: (x[1],x[0][0]))

    for i in ans_list:
        ans.append(i[0])
    print(f'#{tc}',end= ' ')
    print(len(ans),end = ' ')
    for i in ans:
        for j in i:
            print(j,end=' ')
    print()
