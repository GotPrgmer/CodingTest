T = 1
for tc in range(1, T + 1):

    o = []

    score = 0
    for _ in range(4):
        o.append(list(map(int,input())))
    K = int(input())
    for _ in range(K):
        num, cl = map(int,input().split())
        num_real = num -1
        on_off = [0, 0, 0, 0]
        on_off[num_real] = cl
        #돌리는 바퀴의 왼쪽에 있는 바퀴들
        for i in range(num_real-1,-1,-1):
            if o[i+1][-2] != o[i][2]:
                # print(i)
                on_off[i] = -1 * on_off[i+1]
            else:
                break
        # 돌리는 바퀴의 오른쪽에 있는 바퀴들
        for j in range(num_real+1, 4 ):
            if o[j-1][2] != o[j][-2]:
                # print(j)
                on_off[j] = -1 * on_off[j-1]
            else:
                break
        #회전시키기
        # print(on_off)
        # print(o)
        for i in range(4):
            if on_off[i] == 1:
                o[i] = [o[i][-1]] + o[i][0:7]
            elif on_off[i] == -1:
                o[i] = o[i][1:8] + [o[i][0]]


    for i in range(4):
        score += o[i][0] * 2**i
    print(score)