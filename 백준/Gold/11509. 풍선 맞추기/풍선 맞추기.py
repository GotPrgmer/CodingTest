import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
lst = list(map(int,input().split()))

arrows = [0]*1000001

for h in lst:
    #해당 높이에서 화살이 있으면
    if arrows[h]>0:
        arrows[h] -= 1
        arrows[h-1] += 1
    else:
        arrows[h-1] += 1
print(sum(arrows))