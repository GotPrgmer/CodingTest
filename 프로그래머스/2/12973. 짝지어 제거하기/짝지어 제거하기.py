import sys
sys.setrecursionlimit(10**6)
def solution(s):
    stack = []
    for i in range(len(s)):
        if len(stack) == 0:
            stack.append(s[i])
        elif stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])
            
    if len(stack) == 0:
        return 1
    else:
        return 0

