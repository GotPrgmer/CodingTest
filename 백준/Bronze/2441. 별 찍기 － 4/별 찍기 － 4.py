import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
for i in range(n):
    print(" "*i + "*"*(n-i))