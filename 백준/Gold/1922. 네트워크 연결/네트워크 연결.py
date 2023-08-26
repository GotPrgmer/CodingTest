#a와 b가 이어져있어야함

#컴퓨터를 연결하는 비용을 최소

# 다익
#프림
#크루스칼


import sys

def input():
    return sys.stdin.readline().rstrip()

def find(x):
    if x != parent[x]:
        parent[x] =  find(parent[x])
    return parent[x]

def union(a,b):
    root_a = find(a)
    root_b = find(b)
    if root_a == root_b:
        return False
    else:
        if rank[root_a] < rank[root_b]:
            root_a, root_b = root_b, root_a
        parent[root_b]= root_a
        if rank[root_a] == rank[root_b]:
            rank[root_a] += 1
        return True

def kruskal():
    graph.sort(key=lambda x: x[0])
    count = 0
    global ans

    for edge in graph:
        #부모가 다르다!
        if union(edge[1],edge[2]):
            count += 1
            ans += edge[0]
        #부모가 같다!
        if count == N:
            break
        else:
            continue



# def prim()

N = int(input())
M = int(input())
graph = []
ans = 0

parent = [i0 for i0 in range(N+1)]
rank = [1 for i1 in range(N+1)]

for _ in range(M):
    a, b, cost = map(int,input().split())
    graph.append((cost,a,b))

#크루스칼 돌리기
kruskal()
print(ans)
#프림 돌리기


