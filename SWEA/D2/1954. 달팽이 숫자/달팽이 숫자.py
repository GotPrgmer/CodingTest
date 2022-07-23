testcase = int(input())

for case in range(1,testcase + 1):
    howbig = int(input())
    answer = [[0]*howbig for i in range(howbig)]
    for i in range(0,howbig):
        answer[0][i] = i + 1
        number = i +1

    cnt = 1 # 짝수면ㄱ인지 홀수면 ㄴ인지
    cnt_odd = howbig - 1 # for문 두개 거칠때마다 작아짐
    cnt_even = 0 #for 문 하나 거칠때마다 커짐
    fix1 = 1
    fix2 = 1
    for i in range(howbig-2,-1,-1):

        if cnt % 2== 1:
            for row in range(fix1,fix1 + i +1):
                number += 1
                answer[row][cnt_odd] = number

            for col in range(fix1 - 1 + i ,fix1-2,-1):
                number += 1
                answer[cnt_odd][col] = number
            cnt_odd -= 1
            cnt += 1
            fix1 += 1
            if number == howbig * howbig:
                break

        elif cnt % 2 == 0: # cnt가 짝수일때
            for row in range(fix2 + i,fix2-1,-1):
                number += 1
                answer[row][cnt_even] = number
            cnt_even += 1
            for col in range(fix2,fix2 + i+1):
                number += 1
                answer[cnt_even][col] = number
            cnt += 1
            fix2 += 1
            if number == howbig * howbig:
                break

    print(f'#{case}')
    for i in range(howbig):
        for j in range(howbig):
            print(answer[i][j],end=' ')
        print()
