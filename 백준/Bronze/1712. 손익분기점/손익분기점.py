import sys
import math
input = sys.stdin.readline
num = 0

a,b,c = map(int,input().split())

if(c-b<=0):
    print(-1)
elif((a/(c-b)-math.floor(a/(c-b)))==0):
    print(int(a/(c-b)+1))
else:
    print(int(math.ceil(a/(c-b))))
