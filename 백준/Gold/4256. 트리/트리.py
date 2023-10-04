import sys


def input():
    return sys.stdin.readline().rstrip()

def toPost(preList,inList):
    if not len(preList):
        return
    elif len(preList) == 1:
        ans.append(preList[0])
        return
    elif len(preList) == 2:
        ans.append(preList[1])
        ans.append(preList[0])
        return
    root = preList[0]
    rootIdx = inList.index(root)

    preLeft = preList[1:rootIdx+1]
    preRight = preList[rootIdx+1:]

    inLeft = inList[0:rootIdx]
    inRight = inList[rootIdx+1:]
    toPost(preLeft,inLeft)
    toPost(preRight,inRight)
    ans.append(root)

T = int(input())



for _ in range(T):
    N = int(input())
    preorder = list(map(int,input().split()))
    inorder = list(map(int,input().split()))
    ans = []
    toPost(preorder,inorder)
    print(*ans)

