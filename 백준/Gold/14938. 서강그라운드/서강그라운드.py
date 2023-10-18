import sys

def input():
    return sys.stdin.readline().rstrip()

n, m, r = map(int,input().split())

item_gatsu = list(map(int,input().split()))
floidwashal = [[float('INF')]*(n+1) for _ in range(n+1)]

for _ in range(r):
    s, e, c = map(int,input().split())
    floidwashal[s][e] = c
    floidwashal[e][s] = c

for k0 in range(1,n+1):
    for k1 in range(1, n+1):
        if k0 == k1:
            floidwashal[k0][k1] = 0

for i2 in range(1,n+1):
    for i0 in range(1,n+1):
        for i1 in range(1,n+1):
            if floidwashal[i0][i2]+floidwashal[i2][i1] < floidwashal[i0][i1]:
                floidwashal[i0][i1] = floidwashal[i0][i2]+floidwashal[i2][i1]
ans = 0

for i1 in range(1,n+1):
    tmp = []
    cnt = 0
    for idx,value in enumerate(floidwashal[i1]):
        if 0<=value <= m:
            tmp.append(idx)
    for i3 in tmp:
        cnt += item_gatsu[i3-1]
    ans = max(ans,cnt)

print(ans)


