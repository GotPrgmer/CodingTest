from collections import deque
def solution(n, stations, w):
    start = 1
    r = 2*w+1
    end = 0
    ans = 0
    for station in stations:
        length = station - w - start
        if station - w > start:
            ans += length//r if length%r==0 else length//r + 1
        start = station + w + 1
        
    if start <= n:
        length = n+1-start
        ans += length//r if length%r==0 else length//r + 1
    
    return ans