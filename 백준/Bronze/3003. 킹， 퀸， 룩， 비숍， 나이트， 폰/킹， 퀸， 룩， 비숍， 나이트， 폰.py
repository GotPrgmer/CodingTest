lst = list(map(int,input().split()))
for i in range(len(lst)):
    
    if i ==0 or i==1:
            lst[i]= 1-lst[i]
    elif i == 2 or i== 3 or i == 4:
            lst[i]= 2-lst[i]
    elif i == 5:
            lst[i]=8-lst[i]
    
for i in lst:
    print(i,end=' ')
                
    