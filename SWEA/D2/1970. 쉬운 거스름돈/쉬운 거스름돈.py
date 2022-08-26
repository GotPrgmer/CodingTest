T = int(input())

for tc in range(1, T + 1):
    start_money = int(input())
    money_list = [50000,10000,5000,1000,500,100,50,10]
    temp = 0
    ans = []

    for money in money_list:
        temp = start_money // money
        ans.append(temp)
        start_money = start_money % money
    print(f'#{tc}')
    for i in ans:
        print(i,end=' ')
    print()