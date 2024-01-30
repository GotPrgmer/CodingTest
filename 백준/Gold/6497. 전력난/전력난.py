# 모든 길마다 원래 켜져 있던 가로등 중 일부를 소등
# 가로등을 켜두면 하루에 길의 미터 수만큼 돈이 들어가
# 일부를 소등하여 그만큼 돈을 절약할 수 있음

# 어떤 두 집을 왕래할 때, 불이 켜져있지 않은 길을 반드시 지나야 한다면 위험
# 두 집 쌍에 대해 불이 켜진 길만을 서로 왕래해야함
# 절약할 수 있는 최대 액수

#왕래를 할 수 있으면서 가장 크게 절약을 하는 액수를 구하는게 핵심
#모든 노드들이 연결이 되어야 하고 각 각 경로의 합이 최소면
# 전체 다리의 합에서 그 최소를 빼면 최대가 됨
# 고로 mst문제임

import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()



def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(x, y):
    root_x = find_parent(x)
    root_y = find_parent(y)

    if root_x < root_y:
        parent[root_y] = root_x
    else:
        parent[root_x] = root_y
while True:
    m, n = map(int,input().split())
    if m == 0 and n == 0:
        break
    parent = [self for self in range(m)]
    hq = []
    total = 0
    for _ in range(n):
        x, y, z = map(int,input().split())
        heapq.heappush(hq,(z,x,y))
        total += z
    ans = 0
    while hq:
        z, x, y = heapq.heappop(hq)
        if find_parent(x) != find_parent(y):
            union(x,y)
            ans += z
        else:
            continue
    print(total-ans)


