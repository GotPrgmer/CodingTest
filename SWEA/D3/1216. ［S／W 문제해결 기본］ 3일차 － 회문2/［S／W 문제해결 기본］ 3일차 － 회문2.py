def check(row):
    #길이가 홀수인 회문
    cycling_list = []
    cnt = 0
    ans_list = []
    for i in range(0,100):
        cnt = 0
        for j in range(0,100):
            if (0<=i-j<100 and 0<=i+j<100) and row[i-j]==row[i+j]:
                cnt = 2*j + 1
                continue
            else:
                ans_list.append(cnt)
                break
    #길이가 짝수인 회문
    for i in range(99,-1,-1):
        cnt = 0
        for j in range(0,100):
            if (0<=i-j<100 and 0<=(i-j)+2*j+1<100) and row[(i-j)+2*j+1]==row[i-j]:
                cnt = 2*(j+1)
                continue
            else:
                ans_list.append(cnt)
                break
    return max(ans_list)

arr = []
max_int = 0

for _ in range(10):
    max_int = 0
    arr = []
    tc = int(input())
    for i in range(100):
        arr.append(list(map(str,input())))
    for i in range(100):
        if max_int < check(arr[i]):
            max_int = check(arr[i])
    arr = list(zip(*arr))
    for i in range(100):
        if max_int < check(arr[i]):
            max_int = check(arr[i])
    print(f'#{tc} {max_int}')
