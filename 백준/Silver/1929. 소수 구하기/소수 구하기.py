import math
import sys
input = sys.stdin.readline
def isPrime(num):
    if num==1:
        return False

    else:
        for n in range(2,int(math.sqrt(num))+1):
            if num % n==0:
                return False
        return True

M,N = map(int,input().split())

for i in range(M,N+1):
    if isPrime(i):
        print(i)