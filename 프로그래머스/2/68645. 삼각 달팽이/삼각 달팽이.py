def solution(n):
    d_r = (1,0,-1)
    d_c = (0,1,-1)
    max_num = (n*(n+1))//2
    cnt = 1
    snail = [[0]*(i+1) for i in range(n)]
    r = 0
    c = 0
    d = 0
    while cnt <= max_num:
        snail[r][c] = cnt
        #d를 유지하면서 다음차례로 가는지 확인
        nr = r + d_r[d]
        nc = c + d_c[d]
        #가능하면 그대로 진행
        if nr in range(n) and nc in range(len(snail[nr])) and snail[nr][nc] == 0:
            r = nr
            c = nc
            cnt += 1
            continue
        else:
            d = (d+1)%3
            r += d_r[d]
            c += d_c[d]
            cnt += 1
            continue
        #아니면 d를 1더함
    ans = []
    for lst in snail:
        ans.extend(lst)
        
    return ans
        
    #아래로
    
    #