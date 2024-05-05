from collections import deque
d_r = [-1,0,1,0]
d_c = [0,1,0,-1]
def solution(board):
    global map_info
    map_info = board
    answer = 0
    flag = 0
    for r in range(len(board)):
        for c in range(len(board[0])):
            if board[r][c] == 'R':
                start_r = r
                start_c = c
                flag = 1
                break
        if flag == 1:
            break
    ans = bfs(start_r,start_c)
        
    
    return ans

def bfs(r,c):
    q = deque([(r,c,0)])
    visited = set()
    
    while q:
        #현재 지점에서 사방탐색해서 갈수있는 방향으로 쭉 가서 범위안맞거나 D이면 좌표 넣기
        start_r, start_c, cnt = q.popleft()
        if map_info[start_r][start_c] == 'G':
            return cnt
        for d in range(4):
            r = start_r
            c = start_c
            
            while True:
                n_r = r + d_r[d]
                n_c = c + d_c[d]
                if n_r in range(len(map_info)) and n_c in range(len(map_info[0])) and map_info[n_r][n_c] != 'D':
                    r = n_r
                    c = n_c
                else:
                    break
        #r, c를 q에 넣고 visited방문확인하고 q에 넣기
            if (r,c) not in visited:
                visited.add((r,c))
                q.append((r,c,cnt+1))
    return -1
    