import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def diameter(x,start_meter):
    stack = deque([x])
    visited = set()
    first_meter = start_meter
    first_node = tuple()
    #루트에서 가장 먼 점 찾기
    while stack:
        meter, cur = stack.pop()

        if cur in visited:
            continue
        visited.add(cur)
        if first_meter < meter:
            first_meter = meter
            first_node = cur
        for dest in tree[cur]:
            if dest[1] not in visited:
                stack.append((meter+dest[0],dest[1]))

    return (first_meter,first_node)


n = int(input())

tree = [[] for _ in range(n+1)]
if n == 1:
    print(0)
else:    
    for _ in range(n-1):
        parent, child, w = map(int,input().split())
        tree[parent].append((w,child))
        tree[child].append((w,parent))
    first_ans = diameter((0,1),0)
    print(int(diameter((0,first_ans[1]),first_ans[0])[0]))


