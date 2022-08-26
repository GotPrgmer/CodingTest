T = int(input())

for tc in range(1, T + 1):
    how_big = int(input())
    number = input()
    sum = 0
    max_num = 0
    for i in number:
        if i == '1':
            sum += 1
        else:
            if max_num < sum:
                max_num = sum
                sum = 0
    if max_num < sum:
        max_num = sum
        sum = 0
    print(f'#{tc} {max_num}')