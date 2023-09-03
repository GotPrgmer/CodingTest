import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()
preorder = []

while True:
    try:
        preorder.append(int(input()))
    # try에서 예외 발생시 break 실행
    except:
        break

def postorder(first,end):
    if first > end:
        return
    mid = end + 1
    #언제 전항보다 후항이 크게 되지?(왼쪽 서브트리값이 오른쪽 서브트리값보다 작으므로)
    for node_key in range(first+1,end+1):
        if preorder[first] < preorder[node_key]:
            mid =  node_key
            break

    postorder(first+1,mid-1)
    postorder(mid,end)
    print(preorder[first])

postorder(0,len(preorder)-1)