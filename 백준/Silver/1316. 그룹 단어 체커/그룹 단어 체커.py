num = int(input())
grp = 0
count = 0
count_spell = 0
for i in range(num):
    count=0
    count_spell = 0
    word = input()
    word1 = list(set(word))
    for j in word1:
        num =word.count(j)
        if((j*word.count(j)) not in word):
            count_spell += 1
    if(count_spell==0):
        grp += 1
print(grp)