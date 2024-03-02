import sys
from collections import deque

graph = [[] for x in range(8)]
walllist = []
for i in range(8):
    temp = sys.stdin.readline()
    for j in range(8):
        graph[i].append(".")
        if temp[j] == "#":
            walllist.append([i, j])

# start: 7, 0 // end: 0, 7
def bfs():
    cnt = 0
    q = deque([(7, 0)]) # x, y
    while q:
        for _ in range(len(q)):
            x, y = q.popleft()

            if [x,y] in walllist:
                continue
            if x == 0 or cnt == 9:
                print(1)
                return
            adjlist = [[0, 0], [1, 0], [-1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]

            for addx, addy in adjlist:
                nx = addx + x
                ny = addy + y
                if nx >= 0 and nx < 8 and ny >= 0 and ny < 8:
                    if [nx, ny] not in walllist:
                        q.append((nx, ny))
        for i in range(len(walllist)):
            walllist[i] = [walllist[i][0]+1, walllist[i][1]]
        cnt+=1

    print(0)

if len(walllist) == 0:
    print(1)
else:
    bfs()