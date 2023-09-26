import sys

def input():
    return sys.stdin.readline().rstrip()

N, W = map(int,input().split())
adj_lst = [[] for _ in range(N+1)]
parent = [0]*(N+1)
children = [[] for _ in range(N+1)]


for _ in range(N-1):
    U, V = map(int,input().split())
    adj_lst[U].append(V)
    adj_lst[V].append(U)
Stack = [1]
visited = set()
while Stack:
    current_node = Stack.pop()
    if current_node in visited:
        continue
    visited.add(current_node)
    for dest in adj_lst[current_node]:
        if dest not in visited:
            Stack.append(dest)
            parent[dest] = current_node
            children[current_node].append(dest)

leafNodeCnt = 0
for i0 in children:
    if not len(i0):
        leafNodeCnt += 1

print(W/(leafNodeCnt-1))