import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(n-1,-1,-1):
    print(' '*i+'* '*(n-i))

