from collections import deque
d_r = [-1,0,1,0]
d_c = [0,1,0,-1]
def solution(maps):
    global visited
    global map_info
    
    map_info = []
    for info in maps:
        map_info.append(list(info))
    ans = []
    visited = set()
    for r in range(len(map_info)):
        for c in range(len(map_info[0])):
            if map_info[r][c] != "X" and (r,c) not in visited:
                ans.append(bfs(r,c))
    ans = sorted(ans)
    if not ans:
        ans.append(-1)
        
    
    return sorted(ans)

def bfs(start_r,start_c):
    q = deque([(start_r,start_c)])
    sum_value = 0
    while q:
        cur_r, cur_c = q.popleft()
        if (cur_r,cur_c) in visited:
            continue
        visited.add((cur_r,cur_c))
        sum_value += int(map_info[cur_r][cur_c])
        for d in range(4):
            n_r = cur_r + d_r[d]
            n_c = cur_c + d_c[d]
            if n_r in range(len(map_info)) and n_c in range(len(map_info[0])) and (n_r,n_c) not in visited:
                if map_info[n_r][n_c] != "X":
                    q.append((n_r,n_c))
                    
    return sum_value
    
    