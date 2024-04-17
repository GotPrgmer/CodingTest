from collections import deque
def solution(s):
    q = deque(list(s))
    stack = deque([])
    while q:
        cur = q.popleft()
        if cur == ")":
            if stack:
                stack.pop()
            else:
                return False
        else:
            stack.append("(")
    if stack:
        return False
    return True