lst = list(map(int,input().split()))
summ=0
for i in lst:
    summ+=i**2
print(summ%10)