import sys
from collections import deque
from itertools import combinations

def input():
    return sys.stdin.readline()


# 각 집의 치킨거리를 내림차순으로 정렬 후에 M만큼 남도록 지워준다.

N, M = map(int,input().split())

city = [list(map(int,input().split())) for _ in range(N)]

chicken = deque([])
house = deque([])
ans = deque([])


for r in range(len(city)):
    for c in range(len(city[r])):
        if city[r][c] == 1:
            house.append((r,c))
        elif city[r][c] == 2:
            chicken.append((r,c))
sum_ch = 999999
for comb in combinations(chicken,M):
    tmp = 0
    for h in house:
        min_length = 999999
        for ch in comb:
            if min_length > abs(h[0]-ch[0]) + abs(h[1]-ch[1]):
                min_length = abs(h[0]-ch[0]) + abs(h[1]-ch[1])
        #각 집마다 최소값을 더하자
        tmp += min_length
        #모든 집의 최소값을 다 구해서 tmp에 저장을 다 해놓음
    sum_ch = min(sum_ch,tmp)

print(sum_ch)
