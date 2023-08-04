import sys
from collections import deque

def input():
    return sys.stdin.readline()

height = [-1,0,1,0]
width = [0,1,0,-1]

move = 0
N, M , T = map(int,input().split())

princess = (N-1,M-1)

#행, 열 , 시간 카운트, 칼 유무

visited = set()
ans = 999999

dungeon = [list(map(int,input().split())) for _ in range(N)]
if dungeon[0][0] == 2:
    q = deque([(0, 0, 0, 1)])
else:
    q = deque([(0,0,0,0)])

while q:
    current = q.popleft()

    if (current[0],current[1],current[3]) not in visited:
        visited.add((current[0],current[1],current[3]))
        #나 칼 쥐고 있어

        if current[3] == 1:
            for d in range(4):
                if 0 <= current[0]+height[d] < N and 0 <= current[1]+width[d] < M:
                    if (current[0], current[1]) == princess:
                        if ans > current[2]:
                            ans = current[2]
                            break
                    q.append((current[0] + height[d], current[1] + width[d], current[2] + 1, 1))
        # 칼 없으면 내가 다음에 갈 곳이 칼 있는 장소인지 스캔하고
        else:
            for d in range(4):
                if 0 <= current[0]+height[d] < N and 0 <= current[1]+width[d] < M:
                    if (current[0], current[1]) == princess:
                        if ans > current[2]:
                            ans = current[2]
                            break
                    #칼 획득
                    if dungeon[current[0]+height[d]][current[1]+width[d]] != 1:
                        if dungeon[current[0]+height[d]][current[1]+width[d]] == 2:
                            q.append((current[0]+height[d],current[1]+width[d],current[2]+1,1))
                        else:
                            q.append((current[0]+height[d],current[1]+width[d],current[2]+1,0))

if T >= ans >= 0:
    print(ans)
else:
    print('Fail')