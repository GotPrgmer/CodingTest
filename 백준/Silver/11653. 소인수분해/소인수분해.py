number = int(input())
i=2
if(number==1):
    exit()
else:
    while(number != 1):#
        if(number%i==0):#나누어지면 2,3
            number=number//i
            print(i)
        else:
            i+=1