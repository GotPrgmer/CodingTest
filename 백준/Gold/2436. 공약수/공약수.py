import sys
import heapq
import math

def input():
    return sys.stdin.readline().rstrip()

# b에서 a를 나누었을 때 나누어 떨어지면 답이있고 아니면 답이 없음

A, B = map(int,input().split())

if B >= A and B % A == 0:
    C = B // A

    divisor_set = set()
    min_v = float('INF')
    ans = tuple()
    for divisor in range(1, int(C**0.5) + 1):
        if divisor not in divisor_set:
            if C % divisor == 0:
                if math.gcd(divisor,C//divisor) == 1:
                    if A*(divisor+C//divisor) < min_v:
                        ans = (A*divisor,C//divisor*A)
                        min_v = A*(divisor+C//divisor)
        else:
            break

    if ans[0] <= ans[1]:
        print(ans[0],ans[1])
    else:
        print(ans[0],ans[1])
