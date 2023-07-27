import math
from itertools import permutations

k, m = map(int,input().split())
lst = []
tmp_list = []

MAX = 98765 // 10**(5-k)

check = [False,False] + [True]*(MAX - 1)

#소수 리스트 만들기
for i0 in range(2,int(math.sqrt(MAX))+1):
    if check[i0] == True:
        idx = 2*i0
        while idx < len(check):
            check[idx] = False
            idx += i0
prime_list = set()
for i2 in range(len(check)):
    if check[i2] == True:
        prime_list.add(i2)

# 첫번째 조건
# 첫번째 수가 0이 아닌 k자리 숫자 순열
for i1 in permutations(range(0,10),k):
    if i1[0] == 0:
        continue
    Num = int(''.join(list(map(str,i1))))
    tmp = Num
    while tmp % m == 0:
        tmp = tmp // m

    i = 2
    while i <= int(math.sqrt(tmp)):
        if tmp % i == 0:
            if i in prime_list and tmp // i in prime_list:
                sec_prime_idx = 2
                while sec_prime_idx < Num // 2:
                    if sec_prime_idx in prime_list and (Num - sec_prime_idx) in prime_list:
                        tmp_list.append(Num)
                        break
                    sec_prime_idx += 1
        i += 1
print(len(tmp_list))

