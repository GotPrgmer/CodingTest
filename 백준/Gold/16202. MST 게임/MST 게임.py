import sys

def input():
    return sys.stdin.readline().rstrip()

def find_parent(x,parent):
    if parent[x] != x:
        parent[x] =  find_parent(parent[x],parent)
    return parent[x]

def union(parent, x,y):
    x = find_parent(x,parent)
    y = find_parent(y,parent)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

def sol():
    ans_lst = []
    for k in range(K):
        parent = [i for i in range(N+1)]
        score = 0
        nth = 0
        for e in edge[k:]:
            cost, a, b = e
            if find_parent(a,parent) != find_parent(b,parent):
                union(parent,a,b)
                nth += 1
                score += cost
            else:
                continue
        if nth == N - 1:
            ans_lst.append(score)
        else:
            break
    ans_lst.extend([0]*(K-len(ans_lst)))
    return ans_lst


N, M, K = map(int,input().split())


edge = []
for k in range(1,M+1):
    x, y = map(int, input().split())
    edge.append((k, x, y))

print(*sol())