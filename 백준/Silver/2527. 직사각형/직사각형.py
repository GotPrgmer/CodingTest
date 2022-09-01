for line in range(4):
    square = list(map(int,input().split()))
    sq1 = [square[0], square[2],square[1],square[3]]
    sq2 = [square[4], square[6],square[5],square[7]]
    #선분
    #1
    if sq1[0] <= sq2[0] < sq1[1] and sq1[2] == sq2[3] and sq2[2] < sq1[2]:
        print('b')
    #2
    elif sq1[2] < sq2[3] <= sq1[3] and sq1[1] == sq2[0] and sq1[1] < sq2[1]:
        print('b')
    #3
    elif sq1[2] <= sq2[2] < sq1[3] and sq1[1] == sq2[0] and sq1[1] < sq2[1]:
        print('b')
    #4
    elif sq1[0] <= sq2[0] < sq1[1] and sq1[3] == sq2[2] and sq1[3] < sq2[3]:
        print('b')
    #5
    elif sq1[0] < sq2[1] <= sq1[1] and sq1[3] == sq2[2] and sq1[3] < sq2[3]:
        print('b')
    #6
    elif sq1[2] <= sq2[2] < sq1[3] and sq1[0] == sq2[1] and sq2[0] < sq1[0]:
        print('b')
    #7
    elif sq1[2] < sq2[3] <= sq1[3] and sq1[0] == sq2[1] and sq2[0] < sq1[0]:
        print('b')
    #8
    elif sq1[0] < sq2[1] <= sq1[1] and sq1[2] == sq2[3] and sq2[2] < sq1[2]:
        print('b')
    elif sq2[0] < sq1[0] and sq1[1] < sq2[1] and sq1[2] == sq2[3] and sq2[2] < sq1[2]:
        print('b')
    elif sq2[2] < sq1[2] and sq1[3] < sq2[3] and sq1[1] == sq2[0] and sq1[1] < sq2[1]:
        print('b')
    elif sq2[0] < sq1[0] and sq1[1] < sq2[1] and sq1[3] == sq2[2] and sq1[3] < sq2[3]:
        print('b')
    elif sq2[2] < sq1[2] and sq1[3] < sq2[3] and sq1[0] == sq2[1] and sq2[0] < sq1[0]:
        print('b')

    # 점
    elif sq2[0] == sq1[1] and sq2[3] == sq1[2] and sq2[2] < sq1[2]:
        print('c')
    # 1
    elif sq1[1] == sq2[0] and sq2[2] == sq1[3] and sq1[3] < sq2[3]:
        print('c')
    # 2
    elif sq2[1] == sq1[0] and sq2[2] == sq1[3] and sq1[3] < sq2[3]:
        print('c')
    # 3
    elif sq2[1] == sq1[0] and sq2[3] == sq1[2] and sq2[2] < sq1[2]:
        print('c')
    # 4



    # 안겹침
    # 1
    elif sq2[3] < sq1[2]:
        print('d')
    # 2
    elif sq1[1] < sq2[0]:
        print('d')
    # 3
    elif sq1[3] < sq2[2]:
        print('d')
    # 4
    elif sq2[1] < sq1[0]:
        print('d')
    else:
        print('a')