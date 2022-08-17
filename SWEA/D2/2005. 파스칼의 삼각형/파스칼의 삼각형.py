T = int(input())

for tc in range(1,T+1):
    stack = [1]
    N = int(input())
    stack_new = [[1]] + [[] for _ in range(N-1)]
    if N > 1:
        # N - 1번 반복
        for i in range(N-1):
            for j in range(i + 2):
                number_sum = 0
                if 0 <= j-1 < i + 1:
                    number_sum += stack_new[i][j-1]
                if 0 <= j < i + 1:
                    number_sum += stack_new[i][j]
                stack_new[i + 1].append(number_sum)
    print(f'#{tc}')
    for i in range(N):
        for j in range(1,i+2):
            print(stack_new[i][j-1],end=' ')
        print()