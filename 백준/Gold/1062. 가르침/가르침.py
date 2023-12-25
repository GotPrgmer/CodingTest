import sys
from itertools import combinations

def input():
    return sys.stdin.readline().rstrip()

def word2bit(word):
    result = 0
    for c in word:
        result |= 1 << ord(c) - ord('a')
    return result

N, K = map(int,input().split())

input_lst = []
for _ in range(N):
    word = input()
    input_lst.append(word)

#기본 알파벳
base_bit = word2bit('acint')
word_bits = list(map(word2bit,input_lst))
if K < 5:
    print(0)
else:
    #알파벳 비트
    alphabet = [1 << i for i in range(26) if not base_bit & 1 << i]

    ans = 0
    for comb in combinations(alphabet,K-5):

        #가르치는 알파벳 추가함
        tought_bit = sum(comb) | base_bit
        count = 0
        for w2b in word_bits:
            if w2b & tought_bit == w2b:
                count += 1

        ans = max(ans,count)
    print(ans)