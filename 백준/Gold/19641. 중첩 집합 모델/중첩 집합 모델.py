import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()

def sol():
    global tree
    global order
    #트리만들기
    root = S
    order = 0
    tree = [[0,0] for i in range(N+1)]
    dfs(root,1)

    return tree

def dfs(cur,order):
    tree[cur][0] = order
    #왼쪽 서브트리 전부 다 채우기
    #현재 노드와 연결되어있는 부분 다 채우고 돌아와!
    for node in graph[cur]:
        #연결됐겠지
        if tree[node][0]:
            continue
        order = dfs(node,order+1)
    #재귀 채우고 +1 해서 오른쪽 노드 값 채우기
    tree[cur][1] = order + 1
    return order + 1



#노드의 개수
N = int(input())

graph = [[] for _ in range(N+1)]
#간선의 정보
for _ in range(N):
    node, *args = map(int,input().split())
    graph[node] = sorted(args[:-1])
#정점의 노드
S = int(input())
tree = sol()
for i in range(1,N+1):
    print(i,tree[i][0],tree[i][1])
