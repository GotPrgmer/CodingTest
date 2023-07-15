import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N = int(input())


stack = deque([])

for i0 in range(N):
    stack.append(int(input()))

sorted_stack = deque(sorted(stack))
execute = deque([])
ans = deque([])

#정렬된 것들을 넣는 용도
#그러다 stack에 있는것이 보이면 그때 빼기 마지막에 execute의 길이가 0이면 출력
#아니면 No
flag = 1
for i1 in range(N):
    while flag:
        if len(execute) == 0:
            execute.append(sorted_stack.popleft())
            ans.append('+')
        else:
            if execute[-1] == stack[i1]:
                execute.pop()
                ans.append('-')
                break
            elif len(sorted_stack) != 0 and execute[-1] != stack[i1]:
                execute.append(sorted_stack.popleft())
                ans.append('+')
            else:
                flag = 0
                break

    if flag == 0:
        break

if flag == 0:
    print("NO")
else:
    for i2 in range(len(ans)):
        print(ans[i2])
