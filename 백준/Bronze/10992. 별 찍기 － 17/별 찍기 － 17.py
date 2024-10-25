import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(n):
    if i == 0:
        print(((n-1)-i)*' ' +'*' )
    elif i != n-1:
        print(((n-1)-i)*' ' +'*'+' '*(2*(i)-1)+'*' )

    else:
        print('*'*(2*i+1))