from collections import deque
import sys

def input():
    return sys.stdin.readline().rstrip()

S = int(input())

def bfs():
    q = deque([])
    q.append((1,0,0))
    ans = float('INF')
    visited = set()
    while q:
        # print(q)
        screen, clipboard,time = q.popleft()
        if (screen,clipboard) in visited:
            continue
        else:
            visited.add((screen,clipboard))
        if screen==S:
            ans = min(ans,time)
        if screen>S:
            continue
        else:
            #클립보드에 저장
            q.append((screen,screen,time+1))
            #클리보드 붙여넣기
            if clipboard>0:
                q.append((screen+clipboard,clipboard,time+1))
            #화면에서 1개 이모티콘 지움
            if screen>0:
                q.append((screen-1,clipboard,time+1))
    return ans
print(bfs())