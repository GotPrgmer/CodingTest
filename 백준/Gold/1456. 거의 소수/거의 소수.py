import math
import sys

def input():
    return sys.stdin.readline().rstrip()


# 에라토스테네스
def eratos():
    N = int(math.sqrt(B)) + 1
    check = [False]*(2) + [True] * (N)

    for i0 in range(2, len(check)):
        if check[i0] == True:
            prime.append(i0)
            for i1 in range(2 * i0, len(check),i0):
                check[i1] = False
A, B = map(int,input().split())
prime = []

eratos()

#P의 거듭제곱가 몇개들어있을까?
cnt = 0
for i2 in prime:
    tmp = i2*i2
    while True:
        if tmp <=B:
            if A<=tmp:
                tmp *= i2
                cnt += 1
            else:
                tmp *= i2
        else:
            break
print(cnt)
