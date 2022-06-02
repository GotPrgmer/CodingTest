Numbers = int(input())
if((Numbers<=100)&(Numbers>0)):
    lst = [Numbers]
    lst = list(map(int,input().split()))
    prime = 0

    for i in lst:
        if((i>2)&(i<=1000)&(i>0)):
            for j in range(2,i):
                if(i%j==0):
                    break
                elif(j==i-1):
                    prime+=1
        elif(i==2):
            prime += 1
            continue
    print(prime)