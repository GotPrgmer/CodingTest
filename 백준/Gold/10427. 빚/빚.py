import sys

def input():
    return sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):

    N, *borrowed_money = list(map(int,input().split()))
    borrowed_money.sort()
    ans = 0

    #누적합 구하기
    money_cul = [0] + borrowed_money[:]
    for i in range(1, len(money_cul)):
        money_cul[i] += money_cul[i - 1]


    # 0(1)부터 N - 1(N) 인덱스 까지 최소값 구해서 누적시키기

    # 그런데 1개 짜리는 무조건 0이므로 2부터 시작
    for i in range(2,N+1):
        #최소값의 초기화
        min_value = borrowed_money[i-1]*i - money_cul[i]

        #최소값의 갱신
        #i 부터 N-1까지 돌면서 갱신
        for edit_index in range(i,N):
            min_value = min(min_value,borrowed_money[edit_index]*i - (money_cul[edit_index+1] - money_cul[edit_index+1-i]))

        ans += min_value
    print(ans)