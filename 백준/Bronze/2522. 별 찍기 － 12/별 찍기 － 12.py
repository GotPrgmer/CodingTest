import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(1,2*n):
    if i%n != 0:
        value = (i)%n
    else:
        value = n
    if i<=n:
        print(' '*(n-value)+'*'*value)
    else:
        print(' '*(value)+'*'*(n-value))
