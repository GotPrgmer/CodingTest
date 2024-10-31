import sys

def input():
    return sys.stdin.readline().rstrip()

ascending = [1]*1001
descending = [1]*1001
N = int(input())
arr = list(map(int,input().split()))
for i in range(0,N):
    #올라가는거
    for j in range(i):
        if arr[i]>arr[j]:
            ascending[i] = max(ascending[j]+1,ascending[i])
arr = arr[::-1]
for i in range(0,N):
    #내려가는거
    for j in range(i):
        if arr[i]>arr[j]:
            descending[i] = max(descending[j]+1,descending[i])
result = [0]*N
for i in range(N):
    result[i] = ascending[i]+descending[N-i-1]-1
# print(ascending)
# print(descending)
print(max(result))
