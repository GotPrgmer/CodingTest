nanjang_key = []
real_seven_nanjang = []
finish = 0
for _ in range(9):
    nanjang_key.append(int(input()))
nanjang_key = sorted(nanjang_key)

for i in range(1 << len(nanjang_key)):
    real_seven_nanjang = []
    for j in range(len(nanjang_key)):
        if i & 1 << j:
            real_seven_nanjang.append(nanjang_key[j])    #
    if (sum(real_seven_nanjang) == 100) and (len(real_seven_nanjang) == 7):
        for k in range(len(real_seven_nanjang)):
            print(real_seven_nanjang[k])
            finish = 1
    if finish == 1:
        break


