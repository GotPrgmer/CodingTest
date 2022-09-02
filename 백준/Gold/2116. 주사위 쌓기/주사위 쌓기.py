dice_number = int(input())
die_list = []
tmp_max = 0
max_int = 0
tmp = 0
num = 0

for _ in range(dice_number):
    die_list.append(list(map(int,input().split())))

for j in range(len(die_list[0])):
    tmp_max = 0

    if j == 0 or j == 5:
        tmp = 5 - j
        num = die_list[0][tmp]
        tmp_max += max(die_list[0][1],die_list[0][2],die_list[0][3],die_list[0][4])
    elif j == 1 or j == 3:
        tmp = 4 - j
        num = die_list[0][tmp]
        tmp_max += max(die_list[0][0],die_list[0][2],die_list[0][4],die_list[0][5])
    elif j == 2 or j == 4:
        tmp = 6 - j
        num = die_list[0][tmp]
        tmp_max += max(die_list[0][0],die_list[0][1],die_list[0][3],die_list[0][5])
    for k in range(1,len(die_list)):
        if die_list[k].index(num) == 0 or die_list[k].index(num) == 5:
            tmp = 5 - die_list[k].index(num)
            num = die_list[k][tmp]
            tmp_max += max(die_list[k][1], die_list[k][2], die_list[k][3], die_list[k][4])
        elif die_list[k].index(num) == 1 or die_list[k].index(num) == 3:
            tmp = 4 - die_list[k].index(num)
            num = die_list[k][tmp]
            tmp_max += max(die_list[k][0], die_list[k][2], die_list[k][4], die_list[k][5])
        elif die_list[k].index(num) == 2 or die_list[k].index(num) == 4:
            tmp = 6 - die_list[k].index(num)
            num = die_list[k][tmp]
            tmp_max += max(die_list[k][0], die_list[k][1], die_list[k][3], die_list[k][5])
    if max_int < tmp_max:
        max_int = tmp_max
print(max_int)


