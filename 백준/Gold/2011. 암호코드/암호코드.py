import sys

def input():
    return sys.stdin.readline().rstrip()

code_input = list(map(int,input()))
dp = [0]*(len(code_input)+1)
if code_input[0] == 0:
    print("0")
else:
    code_input = [0] + code_input
    dp[0] = dp[1] = 1
    for idx in range(2,len(code_input)):
        if code_input[idx]>0:
            dp[idx] += dp[idx-1]

        if 10 <= code_input[idx - 1]*10 + code_input[idx] <= 26:
                dp[idx] += dp[idx - 2]
    print(dp[len(code_input)-1]%1000000)
