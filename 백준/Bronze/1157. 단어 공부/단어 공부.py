string =  input()
string = string.upper()
lst = []
result =[]
lst = list(map(str,string))
st = set(lst)
my_list = list(st)
for i in range(0,len(my_list)):
    result.append(string.count(my_list[i]))
if(result.count(max(result))>=2):
    print("?")
else:
    print(my_list[result.index(max(result))])