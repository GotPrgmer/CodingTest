from collections import deque


def solution(rectangle, characterX, characterY, itemX, itemY):
    d_r = (-1, 0, 1, 0)
    d_c = (0, 1, 0, -1)
    cooperate = [[-1] * 102 for _ in range(102)]
    for rect in rectangle:
        x1, y1, x2, y2 = map(lambda x: x * 2, rect)
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                if x1 < x < x2 and y1 < y < y2:
                    cooperate[y][x] = 0
                elif cooperate[y][x] != 0:
                    cooperate[y][x] = 1
    characterX, characterY, itemX, itemY = characterX * 2, characterY * 2, itemX * 2, itemY * 2
    print(characterX, characterY, itemX, itemY)
    q = deque([(characterY, characterX)])
    visited = [[1]*102 for _ in range(102)]
    visited[characterY][characterX] = 0
    ans = -1
    while q:
        cur_r, cur_c = q.popleft()
        if cur_r == itemY and cur_c == itemX:
            ans = visited[cur_r][cur_c]//2
            break

        for d in range(4):
            n_r = cur_r + d_r[d]
            n_c = cur_c + d_c[d]
            if cooperate[n_r][n_c] == 1 and visited[n_r][n_c]==1:
                q.append((n_r,n_c))
                visited[n_r][n_c] = visited[cur_r][cur_c] + 1

    return ans
