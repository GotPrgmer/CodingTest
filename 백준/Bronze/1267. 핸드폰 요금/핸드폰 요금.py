n = int(input())
lst = list(map(int,input().split()))

y = 0
m = 0
for i in lst:
    y += (i//30+1)*10
    m += (i//60+1)*15
if (y<m):
    print("Y",y)
elif (m<y):
    print("M",m)
else:
    print("Y M",m)