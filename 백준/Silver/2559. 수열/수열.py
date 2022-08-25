size, day = map(int,input().split())
temperature = list(map(int,input().split()))
max_sum = -102*size
temp = sum(temperature[0:day])


for i in range(size - day + 1):
    if max_sum <= temp:
        max_sum = temp
    if 0<= i <= size - day -1 :
        temp -= temperature[i]
        temp += temperature[i + day]
print(max_sum)