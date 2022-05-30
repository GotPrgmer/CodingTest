lst = list(map(str,input()))
lst = list(reversed(lst))
str =  "".join(lst)
a,b = str.split()
a = int(a)
b = int(b)
if(a>b):
    print(a)
else:
    print(b)
