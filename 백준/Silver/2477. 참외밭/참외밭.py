Number_melon = int(input())

max_odd = 0
max_even = 0
max_odd_idx = 0
max_even_idx = 0
length_list=[]

for i in range(6):
    direction, length = map(int,input().split())
    length_list.append(length)
    if i % 2 and length > max_odd:
        max_odd_idx = i
        max_odd = length
    elif not i % 2 and length > max_even:
        max_even_idx = i
        max_even = length
if (max_odd_idx == 5 and max_even_idx == 0) or max_odd_idx < max_even_idx:
    if max_odd_idx == 5:
        # max_odd_idx = -1
        length_list = length_list[1:6]
    else:
        length_list = length_list[max_even_idx+1:6] + length_list[0:max_even_idx]

else:
    if max_even_idx == 4:
        length_list = length_list[0:4]
    else:
        length_list = length_list[max_odd_idx+1:6] + length_list[0:max_odd_idx]

print(Number_melon*(max_odd * max_even - length_list[1]*length_list[2]))