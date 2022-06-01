num = int(input())

for i in range(num):
    floors,rooms,customers = map(int,input().split())
    #맨 앞 자리가 딱 떨어지는 경우
    if((customers%floors)==0):
        print(floors,end='')
        if((customers//floors)<10):
            print(str(customers//floors).zfill(2))
        else:
            print((customers//floors))
        
    #맨 앞 자리가 딱 떨어지지 않는 경우
    else:
        print(customers%floors,end='')
        if(((customers//floors)+1)<10):
            print(str((customers//floors)+1).zfill(2))
        else:
            print((customers//floors)+1)