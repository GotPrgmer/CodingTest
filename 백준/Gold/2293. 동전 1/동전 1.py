import sys

def input():
    return sys.stdin.readline().rstrip()

#입력받기
n, k = map(int,input().split())

#n개 동전 받기
coins = []
for _ in range(n):
    coins.append(int(input()))

dp = [1] + [0]*(k)
# 최족목표 k를 달성하기 위해 그 보다 작은 i를 달성하는 경우의 수를 구하도록하자
# i를 달성하는 경우의 수를 dp에 저장하여 메모이제이션을 한다.
# i가 k가 됐을 때 출력만 하면된다.
# 현재 보충해야하는 수가 0일 경우 i를 달성했으므로 dp[0]에 1을 저장해서 메모이제이션을 효과적으로 한다.
# dp[i]를 보충할 매개체로 생각을 하면 풀린다.
for coin in coins:
    for i in range(coin,k+1):
        if i - coin >=0:
            dp[i] += dp[i-coin]
print(dp[k])