import sys

def input():
    return sys.stdin.readline().rstrip()

# 수식의 길이
N = int(input())

# 수식 입력
expression = list(map(lambda x:int(x) if x.isdigit() else x, input()))
ans = float('-INF')
def cal(a,b,op):
    if op == '+':
        return a + b
    elif op == '-':
        return a - b
    elif op == '*':
        return a * b

def sol(i, value):
    global ans
    # 수식의 길이까지 왔으면
    if N == i:
        ans = max(ans, int(value))
        return
    # 괄호 사용
    if i + 4 <= N:
        # value는 i번 직전까지 계산한 값
        # i + 2 연산자를 계산하고 i를 계산하고 i + 4로 보낸다.
        sol(i + 4, cal(value,cal(expression[i + 1],expression[i + 3],expression[i+2]),expression[i]))
    sol(i + 2, cal(value,expression[i+1],expression[i]))

if N == 1:
    ans = expression[0]
else:
    sol(1,expression[0])
print(ans)