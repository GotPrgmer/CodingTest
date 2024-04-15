import sys

def input():
    return sys.stdin.readline().rstrip()

def down(r, c):
    cur_r = r
    cur_c = c
    #로깅해보기
    if cur_c in range(k - 1) or cur_c - 1 in range(k - 1):
        if board[cur_r][0] == "?":
            return cur_c
        else:
            #오른쪽범위 확인
            if cur_c in range(k - 1) and board[cur_r][cur_c] == "-":
                return down(cur_r + 1, cur_c + 1)
            elif cur_c-1 in range(k - 1) and board[cur_r][cur_c-1] == "-":
                return down(cur_r + 1, cur_c - 1)
            else:
                return down(cur_r + 1, cur_c)

def up(r, c):
    cur_r = r
    cur_c = c
    if cur_c in range(k - 1) or cur_c - 1 in range(k - 1):
        if board[cur_r][0] == "?":
            return cur_c
        else:
            # 오른쪽범위 확인
            if cur_c in range(k - 1) and board[cur_r][cur_c] == "-":
                return up(cur_r - 1, cur_c + 1)
            elif cur_c - 1 in range(k - 1) and board[cur_r][cur_c - 1] == "-":
                return up(cur_r - 1, cur_c - 1)
            else:
                return up(cur_r - 1, cur_c)


k = int(input())
n = int(input())
alphabet = list(input())
original_alpha = sorted(alphabet)

question = -1
board = []
for r in range(n):
    tmp = list(input())
    if tmp[0] == "?":
        question = r
    board.append(tmp)

#아래로 내려가기
#아래로 내려가도 되나?
down_lst = [i for i in range(k)]
up_lst = [i for i in range(k)]
if question != 0:
    #물음표 나올때까지 내려가기
    for i in range(k):
        down_lst[down(0,i)] = original_alpha[i]
else:
    down_lst = original_alpha
#1 3 0 2 4 6 7 8 9

#위로 올라가기
if question != n-1:
    #물음표 나올때까지 내려가기
    for i in range(k):
        up_lst[up(n-1, i)] = alphabet[i]
else:
    up_lst = alphabet

#물음표 지점에서 정답
flag = 0
ans = []
for i in range(k-1):
    if flag == 0:
        if down_lst[i] == up_lst[i+1] and up_lst[i] == down_lst[i+1]:
            flag = 1
            ans.append("-")
        elif down_lst[i] == up_lst[i]:
            ans.append("*")
        else:
            print("x"*(k-1))
            break
    else:
        ans.append("*")
        flag = 0
if len(ans) == k-1:
    print(''.join(ans))

