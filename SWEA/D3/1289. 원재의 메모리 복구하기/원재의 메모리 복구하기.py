T = int(input())

for tc in range(1, T + 1):
    case = list(map(int,input()))
    ans = 0
    start = -1
    #맨처음 1이 나오는 경우에 break

    #1이 한번이라도 나오면 while
    while sum(case) !=0:
        #처음 1이 나오는 수를 찾
        for i in range(len(case)):
            if case[i] == 1:
                start = i
                break
        #찾은 인덱스부터 반전시키기
        for j in range(start, len(case)):
            case[j] = int(not bool(case[j]))
        ans += 1
    print(f'#{tc} {ans}')






