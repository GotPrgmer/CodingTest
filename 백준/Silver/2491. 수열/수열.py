import sys
input = sys.stdin.readline

Num = int(input())
num_list = list(map(int,input().split()))
max_num = 1
des_cnt = 1
asc_cnt = 1
#앞에서 부터 비교하면 앞 뒤를 비교해서 증
for i in range(len(num_list)-1):
    if num_list[i] >= num_list[i+1]:
        des_cnt += 1
    else:
        if max_num < des_cnt:
            max_num = des_cnt
        des_cnt = 1
if max_num < des_cnt:
    max_num = des_cnt

for i in range(len(num_list) - 1):
    if num_list[i] <= num_list[i+1]:
        asc_cnt += 1
    else:
        if max_num < asc_cnt:
            max_num = asc_cnt
        asc_cnt = 1
if max_num < asc_cnt:
    max_num = asc_cnt
asc_cnt = 1

print(max_num)