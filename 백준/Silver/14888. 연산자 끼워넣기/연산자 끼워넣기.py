#N개의 수
#N-1개의 연산자...
from itertools import permutations
N = int(input())
num_list = list(map(int,input().split()))
sign = []
sign_list = []
sign = list(map(int,input().split()))
for i in range(len(sign)):
    if sign[i] != 0:
        sign_list += [i+1]*sign[i]
max_num = -1000000000
min_num = 1000000000
perm_sign = list(set(permutations(sign_list)))
for i in perm_sign:
    temp = num_list[0]
    for num in range(1,N):
        if i[num-1]==1:
            temp += num_list[num]
        elif i[num-1]==2:
            temp -= num_list[num]
        elif i[num-1]==3:
            temp *= num_list[num]
        elif i[num-1]==4:
            if temp <0:
                temp = -temp
                temp //= num_list[num]
                temp = -temp
            else:
                temp //= num_list[num]
        if not -1000000000<=temp<=1000000000:
            break

        elif num == N-1:
            if temp > max_num:
                max_num = temp
            if temp < min_num:
                min_num = temp
print(max_num)
print(min_num)
