cencoring_alpha = ['C','A','M','B','R','I','D','G','E']

word = input()

for j in range(9):
    word = word.replace(cencoring_alpha[j],'',len(word))
print(word)