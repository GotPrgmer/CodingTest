from collections import deque
def dijkstra():
    global big
    global dist
    global area
    dist = [987654321]*(big**2)
    dist[0] = area[0][0]

    q = deque([(0,0)])
    while q:
        d_r = [-1, 0, 1, 0]
        d_c = [0, 1, 0, -1]
        current = q.popleft()
        for d in range(4):
            x = current[0]+d_r[d]
            y = current[1]+d_c[d]
            if 0 <= x < big and 0 <= y < big:
                    if dist[x*big+y] > dist[current[0]*big+current[1]]+area[x][y]:
                        q.append((x,y))
                        dist[x*big+y] = dist[current[0]*big+current[1]]+area[x][y]
big = int(input())
count = 0
while big != 0:
    area = list(list(map(int,input().split())) for _ in range(big))
    dijkstra()
    ans = dist[big**2-1]
    count += 1
    print(f'Problem {count}: {ans}')
    big = int(input())
