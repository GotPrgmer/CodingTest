import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(1,n+1):
    if i == n:
        print((n - i) * ' ' + '*' * (2 * i - 1),end='')
    else:
        print((n-i)*' ' + '*'*(2*i-1))