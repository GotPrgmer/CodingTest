import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline()

N = int(input())

num = []
visited = set()

def DFS():
    if num:
        visited.add(int(''.join(map(str,num))))
    for i0 in range(10):
        if not num or num[-1] > i0:
            num.append(i0)
            DFS()
            num.pop()

DFS()
ans = sorted(list(visited))
if len(ans) >= N :
    print(ans[N-1])
else:
    print(-1)