import sys

def input():
    return sys.stdin.readline().rstrip()
s = input()
dp = [[0 for _ in range(len(s))] for _ in range(26)]

q = int(input())

for alpha_idx in range(26):
    #문자열 돌면서 누적합을 만들자
    for s_idx in range(len(s)):
        if s[s_idx] == chr(97+alpha_idx):
             if s_idx != 0:
                 dp[alpha_idx][s_idx] = dp[alpha_idx][s_idx-1]+1
             else:
                 dp[alpha_idx][0] = 1
        #해당 알파벳이 일치하지않으면!
        else:
            if s_idx != 0:
                dp[alpha_idx][s_idx] = dp[alpha_idx][s_idx - 1]

#입력 받으면서 정답 구하기
for _ in range(q):
    alphabet, l, r = input().split()
    l = int(l)
    r = int(r)
    if l - 1 >=0:
        print(dp[ord(alphabet)-97][r] - dp[ord(alphabet)-97][l-1])
    else:
        print(dp[ord(alphabet)-97][r])
