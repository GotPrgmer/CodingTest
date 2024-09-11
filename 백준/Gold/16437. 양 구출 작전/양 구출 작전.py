import sys
sys.setrecursionlimit(10**6)
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()
tree = defaultdict(list)
N = int(input())
info = [['',0] for _ in range(N+1)]
info[1] = ['root',0]
for i in range(2,N+1):
    t, a, p = input().split()
    a = int(a)
    p = int(p)
    tree[p].append(i)
    info[i][0] = t
    info[i][1] = a
#dfs로 w이면 합계를 비교하고
#s이면 합계를 더함
def dfs(x):
    cnt = 0
    #w이면
    for i in tree[x]:
        cnt += dfs(i)
    if info[x][0] == 'S' and x != 1:
        cnt += info[x][1]
    elif info[x][0] == 'W':
        cnt = cnt - info[x][1]
    if cnt <= 0:
        cnt = 0
    return cnt

print(dfs(1))

