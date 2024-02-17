import sys
import math
def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

def sol(sausage,pple):
    return math.gcd(sausage,pple)



print(M - sol(N,M))