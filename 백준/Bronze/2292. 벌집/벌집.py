destination = int(input())
#6의 배수로 증가
#1부터 증가해서 
i=1
number = 1
while(1):
    if(destination>number):
        number += 6*i
        i +=1
    else:
        break
print(i)