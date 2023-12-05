from collections import deque
import heapq
import sys

def input():
    return sys.stdin.readline().rstrip()

n, T = map(int, input().split())

# 더 빠른 조회를 위해 집합 사용
points = set()
for _ in range(n):
    r, c = map(int, input().split())
    points.add((r, c))

# BFS
q = deque([(0, 0, 0)])  # 거리를 세 번째 요소로 포함
visited = set()
visited.add((0,0))# 중복 방문을 피하기 위해 방문한 노드 추적
min_dist = float('inf')

while q:
    r, c, dist = q.popleft()
    if c == T:
        min_dist = min(min_dist, dist)
        continue
    for dr in range(-2, 3):  # 제약 조건 내의 모든 가능한 이동 확인
        for dc in range(-2, 3):
            nr, nc = r + dr, c + dc
            if (nr, nc) in points and (nr, nc) not in visited:
                visited.add((nr, nc))
                q.append((nr, nc, dist + 1))

if min_dist == float('inf'):
    print(-1)
else:
    print(min_dist)