import sys
input = sys.stdin.readline

under = int(input())
over = int(input())
prime = []
cnt = 0
for i in range(under,over+1):
    cnt = 0
    for j in range(1,(i//2)+1):
        if(i%j==0):
            cnt+=1
        if((j==(i//2))&(cnt==1)):
            prime.append(i)
if(not prime):
    print(-1)
else:
    print(sum(prime))
    print(min(prime))