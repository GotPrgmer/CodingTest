T = int(input())
d_r = [1,1]
d_c = [1,-1]
for tc in range(1, T + 1):
    #입력받기
    big = int(input())
    board = [list(map(str,input())) for _ in range(big)]
    ans = 'NO'
    direction = 0
    '''
    (N - 5 + 1)x(N - 5 + 1)번 네모를 검색을 한다.
    해당 네모안에서 대각선을 먼저 검사를 하고 세로 가로로 검사하면 됨.
    '''
    if ans =='NO':
        #대각선,가로 세로를 찾자
        #가로찾기
        for row in range(big):
            for col in range(0,big-5+1):
                if board[row][col:col+5].count('o') ==5:
                    ans = 'YES'
                    break
            if ans == 'YES':
                break

    if ans == 'NO':
        #세로찾기
        board = list(zip(*board))
        for row in range(big):
            for col in range(0,big-5+1):
                if board[row][col:col+5].count('o') ==5:
                    ans = 'YES'
                    break
            if ans == 'YES':
                break

    #대각선 찾기(오른쪽 아래로)
    if ans == 'NO':
        for row in range(0,big-5+1):
            for col in range(0,big-5+1):
                o_sum = 0
                r = row
                c = col
                for i in range(5):
                    if board[r][c] == 'o':
                        o_sum += 1
                    if i != 4:
                        r += d_r[direction]
                        c += d_c[direction]

                if o_sum == 5:
                    ans = 'YES'
                    break
            if ans == 'YES':
                break
    #왼쪽 아래로
    direction =1
    if ans == 'NO':
        for row in range(0,big-5+1):
            for col in range(0,big-5+1):
                o_sum = 0
                r = row
                c = col
                c += 4
                for i in range(5):
                    if board[r][c] == 'o':
                        o_sum += 1
                    if i != 4:
                        r += d_r[direction]
                        c += d_c[direction]
                if o_sum == 5:
                    ans = 'YES'
                    break
            if ans == 'YES':
                break

    print(f'#{tc} {ans}')