import sys
import math

def input():
    return sys.stdin.readline().rstrip()

#find
def find(x):
    if parents[x] != x:
        return find(parents[x])
    return x

#union
def union(x,y):
    x = find(x)
    y = find(y)

    if x < y:
        parents[y] = x
    else:
        parents[x] = y

N, M = map(int,input().split())
coordinate = [(-1,-1)]
for i0 in range(N):
    X, Y = map(int,input().split())
    coordinate.append((X,Y))

#이어진 좌표들 하나로 묶기

parents = [i1 for i1 in range(N+1)]

for i2 in range(M):
    s, e = map(int,input().split())
    union(s,e)
graph = []
#같은 집합이 아닌 것들의 거리 구하기
for i3 in range(1,N+1):
    for i4 in range(i3+1,N+1):
        if find(i3) == find(i4):
            continue
        else:
            x_diff = coordinate[i3][0] - coordinate[i4][0]
            y_diff = coordinate[i3][1] - coordinate[i4][1]
            graph.append((math.sqrt(x_diff**2 + y_diff**2),i3,i4))
graph.sort()
ans = 0
for edge in graph:
    cost = edge[0]
    s = edge[1]
    e = edge[2]
    if find(s) != find(e):
        union(s,e)
        ans += cost
    else:
        continue
print(f"{ans:.2f}")





