import sys

def input():
    return sys.stdin.readline().rstrip()

N, K = map(int,input().split())
nums= list(input())

stack = []
cnt = 0
for num in nums:
    while stack and stack[-1] < num and K > 0:
        stack.pop()
        K -= 1
    stack.append(num)
    
#432167
#5365432
if K > 0:
    #다 지워지지 않고 무언가 조건이 안맞아서 계속 들어왔다면
    #K만큼 남았다면 필요한 것만큼 출력
    print(''.join(stack[:-K]))
else:
    #다지워졌으니 고스란히 stack을 출력
    print(''.join(stack))