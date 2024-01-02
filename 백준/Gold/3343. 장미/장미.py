import math
import sys

def input():
    return sys.stdin.readline().rstrip()

N, A, price_A, B, price_B = map(int,input().split())

if B * price_A < price_B * A:
    price_A,price_B = price_B, price_A
    A, B = B, A

ans = float("INF")
for test_num in range(B):
    remain = math.ceil((N-test_num*A)/B)
    isOver = False
    #remain이 음수면 가성비 안좋은 걸로 넘어버림
    if remain < 0:
        remain = 0
        isOver= True
    ans = min(ans,test_num*price_A+remain*price_B)
    if isOver:
        break
print(ans)
