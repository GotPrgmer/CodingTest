T = int(input())

for tc in range(1, T + 1):
    N,k = map(int,input().split())
    Matrix = []
    cnt = 0
    word = 0

    for i in range(N):
        Matrix += [[int(i) for i in input().split()]]

    for row in range(0, N):
        cnt = 0
        for col in range(0, N):
            #값이 1이면 cnt에 1을 더해주고
            #값이 0이고 cnt가 k이면 word올려주고 cnt초기화
            #값이 0이고 cnt가 k가 아니면 cnt초기화
            if Matrix[row][col] == 1:
                cnt += 1
            elif cnt == k:
                word += 1
                cnt = 0
            else:
                cnt = 0
        if cnt == k:
            word += 1
            cnt = 0
        else:
            cnt = 0


    Matrix = list(zip(*Matrix))

    for row in range(0, N):
        cnt = 0
        for col in range(0, N):
            #값이 1이면 cnt에 1을 더해주고
            #값이 0이고 cnt가 k이면 word올려주고 cnt초기화
            #값이 0이고 cnt가 k가 아니면 cnt초기화
            if Matrix[row][col] == 1:
                cnt += 1
            elif cnt == k:
                word += 1
                cnt = 0
            else:
                cnt = 0
        if cnt == k:
            word += 1
            cnt = 0
        else:
            cnt = 0
    print(f'#{tc} {word}')

