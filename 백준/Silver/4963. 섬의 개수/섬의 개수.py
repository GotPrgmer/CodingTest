while True:
    w, h = map(int,input().split())
    if w == h == 0:
        break
    arr = [ list(map(int,input().split())) for _ in range(h) ]
    d_r = [-1,-1,0,1,1,1,0,-1]
    d_c = [0,1,1,1,0,-1,-1,-1]
    visited = set()
    cnt = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and (i,j) not in visited:
                Q = [(i,j)]
                while Q:
                    for _ in range(len(Q)):
                        current = Q.pop(0)
                        if current not in visited:
                            visited.add(current)
                            x = current[0]
                            y = current[1]
                            for d in range(8):
                                if 0 <= x+d_r[d] < h and 0 <= y+d_c[d] < w:
                                    if arr[x+d_r[d]][y+d_c[d]] == 1 and (x+d_r[d],y+d_c[d]) not in visited:
                                        Q.append((x+d_r[d],y+d_c[d]))
                cnt += 1
    print(cnt)



