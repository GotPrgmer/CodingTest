# 키보드가 실용적이냐?
# 문자열 s에서 구간 l, r이 주어지면 알파가 몇번 나오는지 카운트

#최악은... 질문수 * 문자열 개수 => 200000*200000 = 40000000000
# [0,5][0,6]이라 하면 공통된 것들이 포함되면... 나머지들만 연산해주면된다.
# 구간별로 구할 수 있는 구간합을 통해서 구하면 될거같다.

#우선 각 인덱스 별로 어떤 알파벳이 잇는지 보고
#26개 알파벳에 해당하는 누적합을 다 구한다...?
#26*200000 = 51200000
#괜찮겠는데?

#a부터 z까지 누적합 전부 구하기
#어? 그게 아니라 defaultdict를 통해서 들어가지 않은 값은 0으로 처리해서
#0 index에서 a가 나온다면 dp[a]에 a를 넣고

# a = [0,0,0,0,0,0,0]
# b = [0,0,0,0,0,0,0]
# c = [0,0,0,0,0,0,0]
#dp = [0]*27이면... 가능할거같은데?

# 공간복잡도 줄이면서 a~z까지 전부다 각 구간의 분포를 구할 수 있을까?
# dp로도 안되는거같은데 20만*27하면 514만이야...

# 일단 해볼까?
#메모리 공간복잡도 하는법좀 찾아봐야할듯...

s = input()
dp = [[0 for _ in range(len(s))] for _ in range(26)]

q = int(input())

# 문자열 돌면서 누적합 구하기
# 문자열 돌면서 나오는 알파벳 인덱스에 플러스 1?
# 각 알파벳 별로 해야할듯?
# 알파벳 별로 돌면서 인덱스에 1씩 넣으면서 누적합 구하기
# for alphabet in range(1,26+1):
# 97 ~ 122

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
