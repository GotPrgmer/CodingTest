import sys
from collections import deque


d_r = (-1, 0, 1, 0)
d_c = (0, 1, 0, -1)
def input():
    return sys.stdin.readline().rstrip()


#bfs유형이 q에 집어넣고 하나씩 빼서
#다음 차례에서 판단하는 방향의 문제가 대부분인데
#이와 같은 문제는 다른 방향에서 또 시작할 수가 있어서
#하나를 시작하면 끝까지 경로를 유지하는 방향으로 구현하는 문제였음

n, m = map(int, input().split())
visited = [[0] * m for _ in range(n)]


queue = deque()

graph = []
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(m):
        if line[j] == 9:
            #한번에 q에 다 담기
            queue.append((i, j))
            visited[i][j] = 1
    graph.append(line)


def bfs(g, q):

    while q:
        cur_r, cur_c = q.popleft()
        for d in range(4):
            r, c = cur_r, cur_c
            nd_r, nd_c = d_r[d], d_c[d]
            n_r = r + nd_r
            n_c = c + nd_c
            while 0 <= n_r < n and 0 <= n_c < m:
                visited[n_r][n_c] = 1
                if g[n_r][n_c] == 9:
                    break
                if g[n_r][n_c] == 3:
                    nd_r, nd_c = -nd_c, -nd_r
                elif g[n_r][n_c] == 4:
                    nd_r, nd_c = nd_c, nd_r
                elif (g[n_r][n_c] == 1 and nd_r == 0) or (g[n_r][n_c] == 2 and nd_c == 0):
                    break
                n_r += nd_r
                n_c += nd_c
    answer = 0
    for ans in visited:
        answer += ans.count(1)
    return answer


print(bfs(graph, queue))