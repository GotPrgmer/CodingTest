import sys

def input():
    return sys.stdin.readline().rstrip()


def sol():
    #누적합 돌리기
    for cumulative in range(2,2*N):
        dist[cumulative] += dist[cumulative-1]

    #투포인터
    start = 1
    end = 2
    ans = 0
    while end <= N:
        #시계방향
        if dist[end] - dist[start] <= dist[N+start] - dist[end]:
            ans = max(dist[end] - dist[start],ans)
            end += 1
        else:
            ans = max(dist[N+start] - dist[end], ans)
            start += 1
            end = start + 1
    return ans
N = int(input())

dist = [0]*(2*N)

for nth in range(1,N+1):
    this_input = int(input())
    dist[nth+1] = this_input
    if nth+1 < N:
        dist[nth+1+N] = this_input
    else:
        continue

print(sol())