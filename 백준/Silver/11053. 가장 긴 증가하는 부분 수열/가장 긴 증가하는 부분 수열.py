import sys
def input():
    return sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int,input().split()))

def binarySearch(arr,num):
    start = -1
    end = len(arr)-1
    while start+1<end:
        m = (start+end)//2
        if arr[m] < num:
            start = m
        else:
            end = m
    return end


li = [arr[0]]
for i in range(1,len(arr)):
    if arr[i]>li[-1]:
        li.append(arr[i])
    else:
        # print(li)
        idx = binarySearch(li,arr[i])
        # print(idx)
        li[idx] = arr[i]
# print(li)
print(len(li))
