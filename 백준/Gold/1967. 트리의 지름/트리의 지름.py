import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()

def diameter(node,length):
    for dest in tree[node]:
        #해당 노드가 visited에 없으면
        if dist[dest[1]]==-1:
            dist[dest[1]] = length + dest[0]
            diameter(dest[1],dist[dest[1]])


n = int(input())

tree = [[] for _ in range(n+1)]
if n == 1:
    print(0)
else:
    for _ in range(n-1):
        parent, child, w = map(int,input().split())
        tree[parent].append((w,child))
        tree[child].append((w,parent))
    dist = [-1]*(n+1)
    dist[1] = 0
    diameter(1,0)
    first_node = dist.index(max(dist))
    dist = [-1]*(n+1)
    dist[first_node] = 0
    diameter(first_node,0)
    print(max(dist))


