from collections import deque
board = list(list(input().split()) for _ in range(5))
visited = set()
d_r = [-1,0,1,0]
d_c = [0,1,0,-1]
#이동을 할 때에는 한 번 거쳤떤 칸을 다시 거쳐도 된다.
for i in range(5):
    for j in range(5):
        stack = deque([(i,j,'')])
        while stack:
            current = stack.pop()
            if len(current[2]) == 6 and current[2] not in visited:
                visited.add(current[2])
            elif len(current[2]) < 6:
                for d in range(4):
                    x = current[0] + d_r[d]
                    y = current[1] + d_c[d]
                    word = current[2]
                    if current not in stack and 0<=x<5 and 0<=y<5:
                        word += board[x][y]
                        stack.append((x,y,word))
print(len(visited))


