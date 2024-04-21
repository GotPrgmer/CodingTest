import sys
from collections import defaultdict, deque

def input():
    return sys.stdin.readline().rstrip()

def sol():
    global root_num
    q = deque([])
    for name in names:
        if degree[name] == 0:
            q.append(name)
            root_num += 1
            roots.append(name)

    while q:
        cur = q.popleft()
        for name in rel[cur]:
            degree[name] -= 1
            if degree[name] == 0:
                q.append(name)
                children[cur].append(name)


N = int(input())

names = list(input().split())
names.sort()

M = int(input())

rel = defaultdict(list)
degree = defaultdict(int)
children = defaultdict(list)
root_num = 0
roots = []

for _ in range(M):
    X, Y = map(str,input().split())
    rel[Y].append(X)
    degree[X] += 1

sol()
print(root_num)
print(*roots)
for each in names:
    print(each, len(children[each]),*sorted(children[each]))


