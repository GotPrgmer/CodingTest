# 키차이가 최대한 적고싶다
# 조에 원생이 한명이상 들어가야한다.
# 원생들을 K개의 조로 나눈다.
# 인원수 같은 필요없다.
# 한명의 원생만 있으면 비용이 들어가지 않음

import sys
# from collections import defaultdict
def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

differ = []
pple = list(map(int,input().split()))
cut_point = N-1

for i0 in range(0,N-1):
    differ.append(pple[i0+1]-pple[i0])
differ = sorted(differ,reverse=True)
print(sum(differ[M-1:]))