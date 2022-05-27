d=[]
for i in range(19) :
  d.append([])       

for i in range(19):
  d[i] =list(map(int,input().split(' ')))


n =  int(input())
for i in range(n):
    x,y = input().split()
    for j in range(0,19):
        if d[j][int(y)-1]==0:
            d[j][int(y)-1]=1
        else:
            d[j][int(y)-1]=0
        
        if d[int(x)-1][j] == 0:
            d[int(x)-1][j]=1
        else:
            d[int(x)-1][j]=0

for i in range(19):
    for j in range(19):
        print(d[i][j],end=' ')
    print()
