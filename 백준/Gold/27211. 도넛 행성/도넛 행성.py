from collections import deque
import sys
input = sys.stdin.readline
r,c = map(int,input().split(" "))

d_r = [-1,0,1,0 ]
d_c = [0,1,0,-1]

entire = []
for i1 in range(r):
    entire.append(list(map(int,input().split(' '))))



q = deque([(0,0)])
visited = set()
area = 0
for row in range(0,r):
    for col in range(0,c):
        if entire[row][col] == 0 and ((row,col) not in visited):
            area += 1
            q = deque([(row, col)])
            while q:
                current = q.popleft()
                if current  in visited:
                    continue
                visited.add(current)
                for d in range(4):
                    #넘지않음
                    if 0<=current[0] + d_r[d]<r and 0<=current[1]+d_c[d]<c:
                        if entire[current[0] + d_r[d]][current[1]+d_c[d]] == 0:
                            q.append((current[0] + d_r[d],current[1]+d_c[d]))

                    #넘음
                    else:
                        if d == 0:
                            if entire[r-1][current[1] + d_c[d]] == 0:
                                q.append((r-1, current[1] + d_c[d]))

                        elif d == 1:
                            if entire[current[0] + d_r[d]][0] == 0:
                                q.append((current[0] + d_r[d], 0))
                        elif d == 2:
                            if entire[0][current[1]+d_c[d]] == 0:
                                q.append((0, current[1] + d_c[d]))
                        else:
                            if entire[current[0] + d_r[d]][c-1] == 0:
                                q.append((current[0] + d_r[d], c-1))
print(area)