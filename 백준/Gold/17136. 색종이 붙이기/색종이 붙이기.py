# dfs를 활용하자

import sys

def input():
    return sys.stdin.readline().rstrip()

#전체 1의 개수 카운팅
def count():
    cnt = 0
    for row in range(10):
        for col in range(10):
           if board[row][col] == 1:
            cnt += 1
    return cnt

def sol(row,col):
    global ans
    global flag
    #현재 위치에서 1x1에서 5x5까지 가면서
    #스택에 해당 조각이 들어가도 되는지 살펴보고
    # 들어가기 위한 세팅, 체크 및 탐색, 되돌아가기
    # 0,0부터 시작해서 1x1~5x5까지 넣어보고 되는것들만 다음 항을 넣기
    # (5,5,5,5,5) remain이라는 리스트로 관리
    # 색종이들 사용 기록하는게 참 까다롭네...
    #
    if row >= 10:
        flag = 1
        ans = min(ans, sum(paper_cnt))
        return
    if col >= 10:
        sol(row+1,0)
        return

    #해당 지점이 1이면 색종이를 놓을 수 있는 지 확인
    if board[row][col] == 0:
        sol(row,col+1)

    elif board[row][col] == 1:
        #색종이를 놓을 수 있는가?
        for paper in range(5):
            # 놓을 수 있고 놓을 수 있는 부분을 1로 만든다.
            if paper_cnt[paper] < 5:
                if row + paper < 10 and col + paper < 10:
                    if setting_visited(row,col,paper):
                        #1로 만드는 부분
                        for r in range(row,row + paper+1):
                            for c in range(col,col + paper+1):
                                board[r][c] = 0
                        paper_cnt[paper] += 1
                        #보내는 부분
                        sol(row,col+paper+1)
                        #원상복귀하는 부분
                        for r in range(row,row + paper+1):
                            for c in range(col,col + paper+1):
                                board[r][c] = 1
                        paper_cnt[paper] -= 1

def setting_visited(cur_r,cur_c,n):
    for r in range(cur_r,cur_r+n+1):
        for c in range(cur_c,cur_c+n+1):
            if 0<=r<10 and 0<=c<10 and board[r][c] == 1:
                continue
            else:
                return False
    return True




board = [list(map(int,input().split())) for _ in range(10)]

#초기 설정
paper_cnt = [0]*5
ans = 999999
flag = 0

sol(0,0)

#정답 없음
if flag == 0:
    print(-1)
else:
    print(ans)

