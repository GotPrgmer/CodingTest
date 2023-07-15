from collections import deque

N = int(input())

balloons = deque(list(map(int,input().split())))
balloons_idx = deque([i+1 for i in range(N) ])
ans = []

while balloons:
    a = balloons[0]
    if a > 0:
        balloons.popleft()
        balloons.rotate(-(a-1))
        ans.append(balloons_idx.popleft())
        balloons_idx.rotate(-(a-1))
    else:
        balloons.popleft()
        balloons.rotate(-a)
        ans.append(balloons_idx.popleft())
        balloons_idx.rotate(-a)

print(*ans)