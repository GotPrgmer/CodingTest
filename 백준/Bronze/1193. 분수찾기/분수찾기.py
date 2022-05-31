x = int(input())
upper = 1
lower = 1
sum = 0
for i in range(1,x+1):
    sum += i
    if(sum>=x):
        
        sum = sum - i
        cnt = i
        if(cnt%2):
            lower = x-sum
            upper = cnt+1-lower
        else:
            upper = x-sum
            lower = cnt+1-upper
        break

print(str(upper)+"/"+str(lower))