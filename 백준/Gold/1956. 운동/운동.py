import sys

def input():
    return sys.stdin.readline().rstrip()

def sol():
    #dp에 초기값 넣기
    # 한다리에 해당하는 값들
    dp = [[float('INF')]*(V+1) for _ in range(V+1)]
    for s in range(1,V+1):
        for e in range(1,V+1):
            if s == e:
                dp[s][e] = 0
            else:
                if graph[s][e]:
                    dp[s][e] = graph[s][e]

    #플로이드 와샬 돌리기
    # 중간 아이
    for m in range(1,V+1):
        for s in range(1,V+1):
            for e in range(1,V+1):
                if m!=s!=e:
                    dp[s][e] = min(dp[s][e],dp[s][m]+dp[m][e])
    return dp



V, E = map(int,input().split())


graph = [[0]*(V+1) for _ in range(V+1)]
for _ in range(E):
    a, b, c = map(int,input().split())
    graph[a][b] = c

min_val_final = sol()
ans = float('INF')
for s in range(1,V+1):
    for m in range(1,V+1):
        if min_val_final[s][m]*min_val_final[m][s] != float('INF'):
            if min_val_final[s][m] * min_val_final[m][s] != 0:
                ans = min(ans,min_val_final[s][m] + min_val_final[m][s])

if ans == float('INF'):
    print(-1)
else:
    print(ans)
