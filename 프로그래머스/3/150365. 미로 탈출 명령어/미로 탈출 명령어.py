from collections import deque
import sys
sys.setrecursionlimit(10**6)
answer ='z'
def solution(n, m, x, y, r, c, k):
    dist = abs(r-x)+abs(c-y)
    if dist>k or (k-dist)%2==1:
        return "impossible"
    dfs(n,m,x-1,y-1,r-1,c-1,k,'')

    return answer
def dfs(n,m,cur_r,cur_c,r,c,k,path):
    global answer
    if abs(cur_r-r)+abs(cur_c-c)+len(path)>k:
        return
    if cur_r==r and cur_c==c and len(path)==k:
        answer = path
        return
            
    #for문으로 
    for idx,d in enumerate([[1,0],[0,-1],[0,1],[-1,0]]):
        if idx == 0:
            add_str ="d"
        elif idx == 1:
            add_str="l"
            
        elif idx == 2:
            add_str="r"

        elif idx == 3:
            add_str="u"
        n_r = cur_r + d[0]
        n_c = cur_c + d[1]
        if n_r in range(n) and n_c in range(m) and path < answer:
            dfs(n,m,n_r,n_c,r,c,k,path+add_str)                    
                
    
    
        