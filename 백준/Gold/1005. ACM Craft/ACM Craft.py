import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    N, K = map(int,input().split())
    time = [-1] + list(map(int,input().split()))
    sequence = [[] for _ in range(N+1)]
    cnt = [-1] + [0]*(N)
    #노드의 관계와 자식 노드별 카운트를 넣음
    for _ in range(K):
        s, e = map(int, input().split())
        sequence[s].append(e)
        cnt[e] += 1
    destination = int(input())

    #위상정렬 초기값
    dp = [-1]+[0]*(N)
    q = deque([])
    for i0 in range(1,N+1):
        if cnt[i0] == 0:
            q.append(i0)
            dp[i0] = time[i0]

    while q:
        cur = q.popleft()
        for child in sequence[cur]:
            cnt[child] -= 1
            # 비용 갱신
            dp[child] = max(dp[child], dp[cur]+ time[child])
            if cnt[child] == 0:
                q.append(child)
        if cnt[destination] == 0:
            print(dp[destination])
            break






