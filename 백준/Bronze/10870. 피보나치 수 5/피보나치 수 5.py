num = int(input())
a= [0,1]+[0]*(num-1)
for i in range(0,num-1):
    a[i+2]=a[i]+a[i+1]
print(a[num])