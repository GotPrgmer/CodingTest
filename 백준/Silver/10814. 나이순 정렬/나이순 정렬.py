import sys
def input():
    return sys.stdin.readline().rstrip()

N = int(input())
lst = []
for i in range(N):
    x, y = input().split()
    x = int(x)
    lst.append((x,i,y))
lst.sort(key=lambda x:(x[0],x[1]))
for i in lst:
    print(i[0],i[2])
