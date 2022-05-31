import sys
import math
input = sys.stdin.readline
hike = 0
day = 0
a,b,v = map(int,input().split())
num = math.ceil(((v-a)/(a-b)) + 1)
print(num)
