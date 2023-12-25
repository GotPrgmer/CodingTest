import sys
sys.setrecursionlimit(10**6)
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

def inorder(p):
    global last
    if tree[p][0] != -1:
        inorder(tree[p][0])
    last = p
    if tree[p][1] != -1:
        inorder(tree[p][1])


def sudo_mid(p):
    global cnt
    global ans
    if last == p:  # 마지막 노드가 왼쪽 자식이 있을 경우
        ans = cnt
    if tree[p][0] != -1:
        cnt += 1
        sudo_mid(tree[p][0])
        cnt += 1
        if last == p:  # 마지막 노드가 왼쪽 자식이 있을 경우
            ans = cnt

    if tree[p][1] != -1:
        cnt += 1
        sudo_mid(tree[p][1])
        cnt += 1

N = int(input())
tree = defaultdict(list)
last = 0
cnt = 0
ans = 0
for _ in range(N):
    #어떤 노드에서 흠 어디 왼쪽이 있는지 볼까?
    #이제는 오른쪽이 있는지 볼까?
    # 둘 중 걸리면 다시 부모한테 돌아옴
    p, l, r = map(int,input().split())
    tree[p] = [l,r]
if tree[1][0] == -1 and tree[1][1] == -1:
    print(0)
else:
    inorder(1)
    sudo_mid(1)
    print(ans)


