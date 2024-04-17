def solution(arr):    
    zero = 0
    one = 0
    def quad(r,c,l):
        nonlocal zero
        nonlocal one
        if l == 0:
            return


        start_r = r
        start_c = c

        #좌상
        flag = 0
        tmp = arr[start_r][start_c]
        for r in range(start_r,start_r+l):
            for c in range(start_c,start_c+l):
                if arr[r][c] != tmp:
                    flag = 1
                    quad(start_r,start_c,l//2)
                    break
            if flag == 1:
                break
        if flag == 0:
            if tmp == 1:
                one += 1
            else:
                zero += 1

        #우상
        flag = 0
        tmp = arr[start_r][start_c+l]
        for r in range(start_r,start_r+l):
            for c in range(start_c+l,start_c+2*l):
                if arr[r][c] != tmp:
                    flag = 1
                    quad(start_r,start_c+l,l//2)
                    break
            if flag == 1:
                break
                    


        if flag == 0:
            if tmp == 1:
                one += 1
            else:
                zero += 1

        #좌하
        flag = 0
        tmp = arr[start_r+l][start_c]
        for r in range(start_r+l,start_r+2*l):
            for c in range(start_c,start_c+l):
                if arr[r][c] != tmp:
                    flag = 1
                    quad(start_r+l,start_c,l//2)
                    break
            if flag == 1:
                break
        if flag == 0:
            if tmp == 1:
                one += 1
            else:
                zero += 1

        #우하
        flag = 0
        tmp = arr[start_r+l][start_c+l]
        for r in range(start_r+l,start_r+2*l):
            for c in range(start_c+l,start_c+2*l):
                if arr[r][c] != tmp:
                    flag = 1
                    quad(start_r+l,start_c+l,l//2)
                    break
            if flag == 1:
                break

        if flag == 0:
            if tmp == 1:
                one += 1
            else:
                zero += 1
    
    flag = 0
    tmp = arr[0][0]
    for r in range(0,0+len(arr)):
        for c in range(0,0+len(arr)):
            if arr[r][c] != tmp:
                flag = 1
                quad(0,0,len(arr)//2)
                break
        if flag == 1:
            break
        
    if flag == 0:
        if tmp == 1:
            one += 1
        else:
            zero += 1

    return [zero,one]

