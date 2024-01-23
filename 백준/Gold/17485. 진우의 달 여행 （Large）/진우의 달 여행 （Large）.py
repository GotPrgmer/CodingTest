import sys

def input():
    return sys.stdin.readline().rstrip()
#행렬의 크기 받기
N, M = map(int,input().split())

#비용 받기
cost_to_the_moon = [ list(map(int,input().split())) for _ in range(N)]

record_cost_to_the_moon = [[[0] * 3 for _ in range(M)] for _ in range(N)]
for c in range(M):
    for d in range(3):
        record_cost_to_the_moon[0][c][d] = cost_to_the_moon[0][c]

for r in range(1,N):
    for c in range(M):
        for d in range(3):
            if (c == 0 and d == 0) or (c == M-1 and d ==2 ):
                record_cost_to_the_moon[r][c][d] = float('INF')

                continue
            if d == 0:
                record_cost_to_the_moon[r][c][d] = cost_to_the_moon[r][c] + min(
                    record_cost_to_the_moon[r-1][c-1][1],record_cost_to_the_moon[r-1][c-1][2])
            elif d == 1:
                record_cost_to_the_moon[r][c][d] = cost_to_the_moon[r][c] + min(
                    record_cost_to_the_moon[r - 1][c][0], record_cost_to_the_moon[r - 1][c][2])
            else:
                record_cost_to_the_moon[r][c][d] = cost_to_the_moon[r][c] + min(
                    record_cost_to_the_moon[r - 1][c + 1][0], record_cost_to_the_moon[r - 1][c + 1][1])
ans = float('INF')
for part in record_cost_to_the_moon[-1]:
    ans = min(ans,min(part))
print(ans)