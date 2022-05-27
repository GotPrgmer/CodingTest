a, b = input().split()
a = int(a)
b = int(b)
c = int(input())
a += (b+c)//60
b = (b+c)%60
if(a>=24):
    a = a - 24

print(a,b)