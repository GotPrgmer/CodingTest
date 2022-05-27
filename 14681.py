a = int(input())
b = int(input())
if((a>0) & (b>0)):
    print(1)
elif((a<0) & (b<0)):
    print(3)
elif((a>0) & (b<0)):
    print(4)
else:
    print(2)