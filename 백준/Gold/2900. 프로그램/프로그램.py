import sys

def input():
    return sys.stdin.readline().rstrip()

def solve(x):
    i = 0
    while i<N:
        a[i]=a[i]+count[x]
        i += x


N, K =map(int,input().split())
jump = list(map(int,input().split()))
Q = int(input())
a = [0]*N
count = [0]*N
for j in jump:
    count[j] += 1


for j in set(jump):
    solve(j)

for i in range(1,len(a)):
    a[i] += a[i-1]

for _ in range(Q):
    l, r = map(int,input().split())
    if l == 0:
        print(a[r])
    else:
        print(a[r]-a[l-1])
