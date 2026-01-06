import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def solve():
    global flag
    #generation이 0인 것들 다모아
    q = deque([])
    check = set()
    for i in range(len(generation)):
        if generation[i] == 0:
            q.append(i)
    ans = []
    #위상정렬 시작
    while q:
        cur = q.popleft()
        if cur in check:
            flag = 1
            break
        ans.append(cur+1)
        for child in graph[cur]:
            if generation[child]>0:
                generation[child] -= 1
                if generation[child] == 0:
                    q.append(child)
    return ans



T = int(input())
for _ in range(T):
    n = int(input())
    rank = list(map(int,input().split()))
    visited = set()

    pair = int(input())
    for _ in range(pair):
        a, b = map(int,input().split())
        visited.add((a,b))
    generation = [0 for _ in range(n)]
    win = [0 for _ in range(n)]

    #이미 들어가있는 순위들은 반대로 넣고
    #그렇지 않은 것들은 그대로 넣기
    graph = [[] for _ in range(n)]
    flag = 0


    for i in range(n):
        for j in range(i+1,n):
            if rank[i]<rank[j]:
                c,d = rank[i],rank[j]
            else:
                c,d = rank[j],rank[i]

            if (c,d) not in visited:
                graph[rank[i]-1].append(rank[j]-1)
                generation[rank[j]-1] += 1
            else:
                graph[rank[j]-1].append(rank[i]-1)
                generation[rank[i] - 1] += 1
    result = solve()
    if len(result) == n:
        print(*result)
    elif flag == 1:
        print("?")
    #중복되게 값이 들어가는게 아니라 결과값이 부족하면
    else:
        print("IMPOSSIBLE")
