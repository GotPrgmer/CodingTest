import sys

def input():
    return sys.stdin.readline().rstrip()
N = int(input())
lst = []
for _ in range(N):
    name , k, e, m = input().split()
    k = int(k)
    e = int(e)
    m = int(m)
    lst.append((k,e,m,name))
lst.sort(key=lambda x:(-x[0],x[1],-x[2],x[3]))
for i in lst:
    print(i[3])

