import sys
input=sys.stdin.readline
num = int(input())
for i in range(num):
    a,b = input().split()
    a = int(a)
    b = int(b)
    print(a+b)