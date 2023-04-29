import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    P, M, F, C = map(int, input().split(' '))
    #노단골 치킨 갯수
    no_dangol = (M//P) + (M//P*C)//F
    dangol = M // P
    dangol_coupon = M // P * C
    if ( dangol_coupon >= F):
        dangol += (dangol_coupon - F) // (F - C) + 1



    print(dangol - no_dangol)