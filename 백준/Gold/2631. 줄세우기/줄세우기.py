import sys
input = sys.stdin.readline

n = int(input())

d = [1]*(n+1)
num = [0]
for i in range(n):
    num.append(int(input()))

#가장 긴 증가하는 수열 찾기 
for i in range(1,n+1):
    for j in range(1,i):
        if num[j]<num[i]:
            d[i]=max(d[i],d[j]+1)

#n- 긴 증가하는 부분수열의 길이 
print(n-max(d))