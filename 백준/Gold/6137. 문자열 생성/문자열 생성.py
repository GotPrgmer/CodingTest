import sys
from  collections import deque
def input():
    return sys.stdin.readline().rstrip()

N= int(input())
S = deque([])
for _ in range(N):
    S.append(input())

ans = ""
while S:
    #왼쪽이 작으면 왼쪽을 팝
    #오른졲이 작으면 오른쪽을 팝
    #같을때는 while문 돌아줌
    #쭉 들어가면서 왼쪽이 크냐 오른쪽이 크냐에 따라 넣어주면됨
    #마지막까지 들어가도 다 같으면 둘중 아무거나 넣자.
    if S[0]<S[-1]:
        ans += S.popleft()
        continue
    elif S[0]>S[-1]:
        ans += S.pop()
        continue

    #while
    tmp_s = 0
    tmp_e = len(S)-1
    flag = 0
    while tmp_s<=tmp_e:
        if S[tmp_s] < S[tmp_e]:
            flag = 1
            break
        elif S[tmp_s] > S[tmp_e]:
            flag = 2
            break
        else:
            tmp_s += 1
            tmp_e -= 1
    #아무거나 팝
    if flag == 0:
        ans += S.popleft()
    elif flag == 1:
        ans += S.popleft()
        flag = 0
    else:
        ans += S.pop()
        flag = 0
for i in range(len(ans)):
    print(ans[i],end="")
    if (i+1)%80==0:
        print()

