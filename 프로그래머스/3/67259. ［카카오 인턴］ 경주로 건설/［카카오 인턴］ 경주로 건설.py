from collections import deque
def solution(board):
    return min(bfs(board,1),bfs(board,2))

def bfs(board,x):
    d_r = [-1,0,1,0]
    d_c = [0,1,0,-1]
    visited = [[987654321 for _ in range(len(board[0]))] for _ in range(len(board))]
    q = deque([(0,0,0,x)])
    while q:
        cur_r, cur_c, cur_cost,cur_dir = q.popleft()
        if visited[cur_r][cur_c] >= cur_cost:
            visited[cur_r][cur_c] = cur_cost
        else:
            continue
        if cur_r == len(board)-1 and cur_c == len(board)-1:
            continue
        else:
            for d in range(4):
                n_r = cur_r + d_r[d]
                n_c = cur_c + d_c[d]
                # print(cur_r,cur_c,cur_cost,cur_dir)
                if n_r in range(len(board)) and n_c in range(len(board)) and board[n_r][n_c]!=1:
                    if cur_dir != d and (cur_dir+d)%2==0:
                        continue
                    #직진
                    cost = cur_cost
                    if (cur_dir+d)%2==0:
                        cost += 100
                    #코너
                    else:
                        cost += 600
                    q.append((n_r,n_c,cost,d))
    return visited[-1][-1]