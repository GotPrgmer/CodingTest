import sys

def input():
    return sys.stdin.readline().rstrip()


# 그래프 탐색말고도 구하는 방법....

#유니온 파인드...?

def find(x):
    if parents[x] != x:
        return find(parents[x])
    return parents[x]


def union(x,y):
    x = find(x)
    y = find(y)
    if x < y:
        parents[y] = x
    else:
        parents[x] = y
T = int(input())

for t in range(T):
    print("Scenario " +str(t+1) + ":")
    n = int(input())
    k = int(input())
    parents = [x for x in range(n)]

    for _ in range(k):
        a, b = map(int,input().split())
        union(a,b)

    m = int(input())
    for _ in range(m):
        u, v = map(int,input().split())
        if find(u) == find(v):
            print(1)
        else:
            print(0)
    if t < T - 1:
        print()







