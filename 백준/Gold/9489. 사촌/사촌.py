import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

while True:
    n, k = map(int, input().split())
    if n == 0:
        break
    nodes = list(map(int,input().split()))

    parents = defaultdict(int)
    upper_generation = 0
    #트리만들기
    for i0 in range(1,n):
        #현 노드에 부모노드 넣기
        parents[nodes[i0]] = nodes[upper_generation]
        #다음노드와 차이가 1이상 차이가 나면 부모세대를 1 더하기
        if i0 < n - 1 and 1 < nodes[i0+1] - nodes[i0]:
            upper_generation += 1
    #조부모 찾기
    if parents[parents[k]]:
        ans = 0
        #내 부모님말고 다른 부모형제는 누가 있을까?
        for cnd in nodes:
            if parents[parents[k]] == parents[parents[cnd]] and parents[k] != parents[cnd]:
                ans += 1
        print(ans)
    else:
        print(0)

