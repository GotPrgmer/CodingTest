import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

def delete_dfs(num):
    tree_list[num] = -100
    for i0 in range(len(tree_list)):
        if tree_list[i0] == num:
            delete_dfs(i0)


N = int(input())
tree_list = deque(list(map(int,input().split())))
delete_node = int(input())
ans = 0

delete_dfs(delete_node)
for i1 in range(len(tree_list)):
    if tree_list[i1] != -100 and i1 not in tree_list:
       ans += 1

print(ans)
