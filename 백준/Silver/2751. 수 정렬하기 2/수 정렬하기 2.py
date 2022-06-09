import sys

input= sys.stdin.readline
N= int(input())
arr=[]
for i in range(N):
    e=int(input())
    arr.append(e)
arr=sorted(arr)

for i in arr:
    print(i)