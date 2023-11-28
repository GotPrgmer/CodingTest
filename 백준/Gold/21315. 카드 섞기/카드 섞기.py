import sys
import math

def input():
    return sys.stdin.readline().rstrip()

def shuffle(cards,standard_index):
    if standard_index == 0:
        return cards
    # 끝에서 2^(k-i+1)개의 카드는 N - 2^(k-i+1) 부터 끝까지의 카드다
    moving_cards = cards[len(cards)-standard_index:]
    # 인덱스를 2만큼 나누면서 반복하자 그리고 처음부터 N - 2^(k-i+1)까지의 카드를 뒤에 붙여주자
    return shuffle(moving_cards,standard_index//2) + cards[:len(cards)-standard_index]

N = int(input())
cards = list(map(int,input().split()))

result = []
range_k = int(math.log2(N))
flag = 0

for k1 in range(1,range_k+1):
    for k2 in range(1,range_k+1):
        card_list = [i for i in range(1,N+1)]
        if shuffle(shuffle(card_list,2**k1),2**k2) == cards:
            result.append(k1)
            result.append(k2)
            flag = 1
            break
    if flag == 1:
        break

print(*result)
