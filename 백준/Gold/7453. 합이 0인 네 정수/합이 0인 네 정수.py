import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
A=[]
B=[]
C=[]
D=[]
for _ in range(n):
    a, b, c, d = map(int,input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

sum_AB = defaultdict(int)
sum_CD = defaultdict(int)
#AB
for a in A:
    for b in B:
        sum_AB[a+b] += 1


ans = 0
for c in C:
    for d in D:
        sum_cd = c+d
        if -sum_cd in sum_AB.keys():
            ans += sum_AB[-sum_cd]
print(ans)