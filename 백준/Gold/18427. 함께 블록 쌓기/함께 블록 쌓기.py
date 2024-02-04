# 모든 경우의 수는 10^50승이므로 절대 안됨
# 합산이 반드시 M이 되어야하는 냅색문제가 아닐까 싶었음
# 근데 냅색문제를 제대로 못해서 잘 모르겠음...
#
# 답 찾아보자
# 냅색 문제가 맞았고 이 풀이를 이해한다음 냅색 문제를 한번 풀어봐야겠다.
# dp[i][h] 로 정의 하였고, i번째 학생까지 확인했을 때, h인 블록을 쌓을 경우의 수란다.
# 두가지로 나누면 i번째 학생의 블록을 사용하는 것과 i번째 학생의 블록을 사용하지 않는 것
# 두가지를 합친게 dp[i][h]
# 순서를 지켜가며 각 층을 만족하는 경우의 수 문제로 쪼개다보니
# dp[i][h]가 되지 않았는가 싶다.(i와 h가 변수이다.)

# i번째 학생을 선택할때
# 선택하지 않거나, 가진 블록에서 선택하거나
# 선택하지 않을때는 dp[i-1][h]이고
# 선택할 때는 dp[i-1][h-h[1]]+dp[i-1][h-h[2]] +dp[i-1][h-h[3]] ... 이다.


import sys
def input():
    return sys.stdin.readline().rstrip()

N, M, H = map(int,input().split())
student_blocks = [list(map(int,input().split())) for _ in range(N)]

# dp
dp = [[1]+[0]*(H) for _ in range(N+1)]

for st in range(1,N+1):
    #높이가 1부터 하나씩 경우의수를 구한다.
    for h in range(1,H+1):
        # 블록을 선택할지 안할지 선택
        for block_i in range(len(student_blocks[st-1])):
            # 블록을 선택할 경우
            # 해당 블록이 현재 높이 h보다 작거나 같으면 선택할지 안할지 선택할 수 있으므로
            if h >= student_blocks[st-1][block_i]:
                dp[st][h] = (dp[st][h] + dp[st-1][h-student_blocks[st-1][block_i]]) % 10007
        #블록을 선택하지 않을경우
        dp[st][h] = (dp[st][h] + dp[st-1][h]) % 10007
print(dp[N][H])