import sys

#입력
N, M, X = map(int, input().split())
distance = [[M * 100 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(M):
    start, end, time = map(int, sys.stdin.readline().split())
    distance[start][end] = time


#플로이드 와샬 알고리즘
for k in range(1, N+1): #경로 for문이 가장 상위 단계여야 누락되지 않는다
    for i in range(1, N+1):
        if distance[i][k] != M * 100:
            for j in range(1, N+1):
                if i == j: #자기 자신일 경우
                    distance[i][j] = 0 
                else:
                    distance[i][j] = min(distance[i][j],
                                         distance[i][k] + distance[k][j])


#출력
max_time = 0
for i in range(1, N+1):
    max_time = max(max_time,
                   distance[i][X] + distance[X][i])
print(max_time)