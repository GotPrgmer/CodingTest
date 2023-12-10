import math
import sys

def input():
    return sys.stdin.readline().rstrip()

#소수를 우선 출력 에라토스테네스로 소수다꺼내고


def primecheck(num):
    for i0 in range(2,int(math.sqrt(num))+1):
        if num % i0 == 0:
            return False
    return True
#그 소수가 팰린드롬인지 체크
def palindrome(num):
    num = str(num)
    if num == num[::-1]:
        return True
    else:
        return False
a, b = map(int,input().split())
if b > 10000000:
    b = 10000000
palindrome_lst = [num for num in range(a,b+1) if palindrome(num)]
prime_lst =[num1 for num1 in palindrome_lst if primecheck(num1)]
for num2 in prime_lst:
    print(num2)
print(-1)