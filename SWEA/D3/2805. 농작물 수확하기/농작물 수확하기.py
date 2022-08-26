T = int(input())

for tc in range(1, T + 1):
    big = int(input())
    farm = [list(map(int,input())) for _ in range(big)]
    middle = big//2
    get = 0

    for i in range(big//2):
        get += sum(farm[i][middle-i:middle+i+1])
    get += sum(farm[big//2])
    row = big//2
    for i in range(big//2-1,-1,-1):
        row += 1
        get += sum(farm[row][middle-i:middle+i+1])

    print(f'#{tc} {get}')