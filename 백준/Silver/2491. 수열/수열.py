import sys
input = sys.stdin.readline

Num = int(input())
num_list = list(map(int,input().split()))
ascending_num_list = sorted(num_list,reverse=True)
descending_num_list = sorted(num_list)
max_num = 1
des_cnt = 1
asc_cnt = 1

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