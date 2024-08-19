import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()




# 각 자리마다 함께 뒤집어지는 애들이 있음
# 현재 검은색인 것들을 기록하고
# 0~8까지 방문하면서 거쳐가는것들을 visited로 기록
coFlip = [[0,1,3],[0,1,2,4],[1,2,5],[0,3,4,6],[1,3,4,5,7],[2,4,5,8]
    ,[3,6,7],[4,6,7,8],[5,7,8]]
def solve(curState):
    q= deque([[0,0,curState]])
    visited =set()
    ans = float('inf')
    while q:
        cur,click,currentState = q.popleft()
        if int(currentState)==0:
            ans=min(ans,click)
            continue
        #현재 현황이 visited에 있다면
        elif currentState in visited:
            continue
        #없다면
        visited.add(currentState)
        #클릭수 하나 올리고
        #coFlip으로 현재 판 수정하고 q에 넣어주기
        for i in range(9):
            tmp = currentState
            for j in coFlip[i]:
                if tmp[j] == "1":
                    tmp=tmp[0:j]+"0"+tmp[j+1:]
                else:
                    tmp=tmp[0:j]+"1"+tmp[j+1:]
            q.append([i,click+1,tmp])



    return ans






T = int(input())
for _ in range(T):
    curState = ""
    for idx in range(3):
        n = input()
        for i in range(3):
            if n[i]=='*':
                curState+="1"
            else:
                curState+="0"
    print(solve(curState))


