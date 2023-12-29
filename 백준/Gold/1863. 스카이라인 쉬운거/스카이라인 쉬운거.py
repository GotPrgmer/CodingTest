import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
stack = []
ans = 0
for _ in range(n):
    idx, view = map(int,input().split())
    while len(stack) > 0 and stack[-1] > view:
        ans += 1
        stack.pop()
    if len(stack)>0 and stack[-1] == view:
        continue

    stack.append(view)

while len(stack)>0:
    if stack[-1] >0:
        ans+=1
    stack.pop()

print(ans)