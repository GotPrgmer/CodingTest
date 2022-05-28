import sys
input = sys.stdin.readline
num = int(input())
for i in range(1,num+1):
    a,b = input().split()
    a = int(a)
    b = int(b)
    print('Case '+'#'+str(i)+":",a+b)
