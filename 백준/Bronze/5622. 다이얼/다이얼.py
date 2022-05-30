str =  list(map(str,input()))
summ = 0
for i in str:
    if((i=='A')|(i=='B')|(i=='C')):
        summ +=3
    elif((i=='D')|(i=='E')|(i=='F')):
        summ +=4
    elif((i=='G')|(i=='H')|(i=='I')):
        summ +=5
    elif((i=='J')|(i=='K')|(i=='L')):
        summ +=6
    elif((i=='M')|(i=='N')|(i=='O')):
        summ +=7
    elif((i=='P')|(i=='Q')|(i=='R')|(i=='S')):
        summ +=8
    elif((i=='T')|(i=='U')|(i=='V')):
        summ +=9
    elif((i=='W')|(i=='X')|(i=='Y')|(i=='Z')):
        summ +=10
    elif(i==0):
        summ +=11
    else:
        summ +=2

print(summ)