import sys

def input():
    return sys.stdin.readline().rstrip()

n = int(input())
stack = []
max_value = 0
ans = 0
for _ in range(n):
    this_int = int(input())
    max_value = max(max_value, this_int)

    if len(stack) == 0:
        stack.append(this_int)
    else:
        if stack[-1] > this_int:
            stack.pop()
            stack.append(this_int)
        elif stack[-1] < this_int:
            ans += this_int - stack.pop()
            stack.append(this_int)


while stack:
    ans += max_value - stack.pop()

print(ans)



#앞에서 가면서 최대값 갱신 시키면서 최대값이랑 비교함


