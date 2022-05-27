a,b = input().split()
a = int(a)
b = int(b)

if((a!=0)&(b>=45)):
    b = b-45
    print(a,b)
elif((a!=0)&(b<45)):
    a = a -1
    b = 60 +b -45
    print(a,b) 
elif((a==0)&(b<45)):
    a = 24+a -1
    b = 60 +b -45
    print(a,b) 
elif((a==0)&(b>=45)):
    b = b -45
    print(a,b) 