import sys
input = sys.stdin.readline

while(1):
    a,b = input().split()
    a = int(a)
    b = int(b)
    if((a==0)&(b==0)):
        break;
    else: 
        print(a+b)