num = int(input())

for i in range(num):
    a,b = input().split()
    lst = list(map(str,b))
    a = int(a)
    for j in range(len(lst)):
        print(lst[j]*a,end="")
    print("")