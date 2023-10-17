import sys

def input():
    return sys.stdin.readline().rstrip()

N, M , k = map(int,input().split())
A_list = list(map(int,input().split()))
parent = [i for i in range(N+1)]
def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x,y):
    x_parent = find(x)
    y_parent = find(y)
    if A_list[x_parent-1]<A_list[y_parent-1]:
        parent[y_parent] = x_parent
    else:
        parent[x_parent] = y_parent



for i0 in range(M):
    v, w = map(int,input().split())
    union(v,w)

friends = set()
ans = 0
for i1 in range(1,N+1):
    if find(i1) not in friends:
        friends.add(parent[i1])
        ans += A_list[parent[i1]-1]

if ans <= k:
    print(ans)
else:
    print("Oh no")

