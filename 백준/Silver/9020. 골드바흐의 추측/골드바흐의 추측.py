import sys
t = int(input())
prime = []
comb = []

for i in range(2, 10001):
    for j in range(2, int(i**0.5)+1):
        if i%j == 0:
            break
    else:
        prime.append(i)

for _ in range(t):
    num = int(sys.stdin.readline())
    for i in range(int(num/2),1,-1):
        j = num - i
        if (i in prime) and (j in prime):
            print(i,j)
            break