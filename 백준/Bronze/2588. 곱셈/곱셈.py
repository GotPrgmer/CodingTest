a = int(input())
b =int(input())
lst1=list(map(int,str(b)))
for i in range(len(lst1)-1,-1,-1):
    print(a*lst1[i])
print(a*b)

