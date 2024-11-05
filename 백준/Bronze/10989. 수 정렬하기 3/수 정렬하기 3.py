import sys
input = sys.stdin.readline
N = int(input())
lst = []
count = [0]*(10001)
result= [0]*(len(lst))

for _ in range(N):
    count[int(input())]+=1

for i in range(10001):
    if count[i] != 0:
        for j in range(count[i]):
            print(i)