import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(2*n-1):
    value = (i + 1) % n
    if i<n-1:
        print('*'*(value)+' '*(n-value)*2+'*'*value)
    else:
        print('*'*(n-value)+' '*(value)*2+'*'*(n-value))
