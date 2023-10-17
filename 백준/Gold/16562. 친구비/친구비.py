import sys

def input():
    return sys.stdin.readline().rstrip()

N, M , k = map(int,input().split())
A_list = [0]+list(map(int,input().split()))
parent = [i for i in range(N+1)]
# def find(x):
#     if parent[x] != x:
#         parent[x] = find(parent[x])
#     return parent[x]
#
# def union(x,y):
#     x_parent = find(x)
#     y_parent = find(y)
#     if A_list[x_parent-1]<A_list[y_parent-1]:
#         parent[y] = x_parent
#     else:
#         parent[x] = y_parent

def find(x: int) -> int:
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(x: int, y: int) -> None:
    x, y = find(x), find(y)
    # 친구비를 기준으로 부모 설정
    if A_list[x] < A_list[y]:
        parent[y] = x
    else:
        parent[x] = y


for i0 in range(M):
    v, w = map(int,input().split())
    union(v,w)

friends = set()
ans = 0
for i1 in range(1,N+1):
    if find(i1) not in friends:
        friends.add(parent[i1])
        ans += A_list[parent[i1]]

if ans <= k:
    print(ans)
else:
    print("Oh no")

