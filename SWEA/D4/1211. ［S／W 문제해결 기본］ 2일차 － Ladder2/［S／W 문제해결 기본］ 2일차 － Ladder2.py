
for tc in range(10):
    T = int(input())
    ladder = [list(map(int,input().split())) for _ in range(100)]
    start = []
    d_row = [1,0,0]
    d_col = [0,1,-1]
    min_cnt = 9999999999
    min_idx = 0

    for i in range(100):
        if ladder[0][i] == 1:
            start.append(i)
        else:
            continue

    for i in start:
        col = i
        row = 0
        cnt = 0
        while row < 99:
            #오른쪽으로 가기
            if 0 <= col+d_col[1] <= 99 and ladder[row][col+d_col[1]]:
                #길로 들어가기
                row += d_row[1]
                col += d_col[1]
                cnt += 1
                while ladder[row + 1][col] != 1:
                    row += d_row[1]
                    col += d_col[1]
                    cnt += 1
                row += d_row[0]
                col += d_col[0]
            # 왼쪽으로 가기
            elif 0 <= col+d_col[2] <= 99 and ladder[row][col+d_col[2]]:
                #길로 들어가기
                row += d_row[2]
                col += d_col[2]
                cnt += 1
                while ladder[row + 1][col] != 1:
                    row += d_row[2]
                    col += d_col[2]
                    cnt += 1
                row += d_row[0]
                col += d_col[0]
            #직진하기
            else:
                row += d_row[0]
                col += d_col[0]
                cnt += 1
        if min_cnt > cnt :
            min_cnt = cnt
            min_idx = i
    print(f'#{T} {min_idx}')





