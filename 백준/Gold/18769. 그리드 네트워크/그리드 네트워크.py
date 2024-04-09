import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()
def find_parent(x):
    if parents[x] != x:
        parents[x] =  find_parent(parents[x])
    return parents[x]

def union(x,y):
    x = find_parent(x)
    y = find_parent(y)

    if x < y:
        parents[y] = x
    else:
        parents[x] = y



def sol():
    global ans
    visited = set()
    cnt = 0
    while q:
        cost, s, e = heapq.heappop(q)
        #들어가도 되는지
        s_num = s[0]*C + s[1]
        e_num = e[0]*C + e[1]
        if find_parent(s_num) != find_parent(e_num):
            union(s_num,e_num)
            ans += cost
            cnt += 1
        if cnt == R*C - 1:
            return ans


T = int(input())

for _ in range(T):
    R, C = map(int,input().split())
    parents = [i for i in range(R*C)]
    ans = 0

    #가로 비용
    q = []
    for r in range(R):
        horizon_cost = list(map(int,input().split()))
        #엣지 추가하기
        for c in range(len(horizon_cost)):
            heapq.heappush(q,(horizon_cost[c],(r,c),(r,c+1)))
    #세로 비용
    for r in range(R-1):
        vertical_cost = list(map(int,input().split()))
        #엣지 추가하기
        for c in range(len(vertical_cost)):
            heapq.heappush(q,(vertical_cost[c],(r,c),(r+1,c)))


    print(sol())


