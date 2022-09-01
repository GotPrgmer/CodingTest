max_cnt = 2
first = int(input())
remember_list = []
tmp_list = []
tmp = first
for i in range(1,first+1):
    cnt = 1
    first = tmp
    tmp_list = [first,i]
    while first >= 0:
        first , i = i , first - i
        cnt += 1
        if i>=0:
            tmp_list.append(i)
        else:
            break
    if max_cnt < cnt:
        max_cnt = cnt
        remember_list =tmp_list

print(max_cnt)
print(*remember_list)
