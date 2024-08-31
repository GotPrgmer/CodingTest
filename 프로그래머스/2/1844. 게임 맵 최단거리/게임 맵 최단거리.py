from collections import deque
def solution(maps):
    answer = 0
    d_r = [-1,0,1,0]
    d_c = [0,1,0,-1]
    q = deque([(0,0)])
    visited = [[0]*len(maps[0]) for _ in range(len(maps))]
    visited[0][0] = 1
    ans = -1
    while q:
        cur_r, cur_c = q.popleft()
        if cur_r == len(maps)-1 and cur_c == len(maps[0])-1 and visited[cur_r][cur_c]!= 0:
            ans = visited[cur_r][cur_c]
            break
        for d in range(4):
            n_r = cur_r + d_r[d]
            n_c = cur_c + d_c[d]
            if n_r in range(len(maps)) and n_c in range(len(maps[0])):
                if maps[n_r][n_c] == 1 and visited[n_r][n_c] == 0:
                    q.append((n_r,n_c))
                    visited[n_r][n_c] = visited[cur_r][cur_c] + 1
            continue
    return ans