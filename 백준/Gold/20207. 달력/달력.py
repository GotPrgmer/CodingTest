import sys

def input():
    return sys.stdin.readline().rstrip()

N =  int(input())

#들어오는 것들을 리스트에 1과 -1로 넣기
todolist = [0]*(367)
for _ in range(N):
    s, e = map(int,input().split())
    todolist[s] += 1
    todolist[e+1] += -1
for i0 in range(1,len(todolist)):
    todolist[i0] += todolist[i0-1]
flag = 0
cnt = 0
height = 0
ans = 0
for i1 in range(1,367):
    if todolist[i1] >= 1 and flag == 0:
        flag = 1
        cnt += 1
        height = max(height,todolist[i1])
    elif flag == 1 and todolist[i1] == 0:
        ans += height * cnt
        height = 0
        flag = 0
        cnt = 0
    elif flag == 1 and todolist[i1] >= 1:
        height = max(height,todolist[i1])
        cnt += 1
print(ans)



