total = int(input())
number = int(input())
summ = 0
for i in range(number):
    A, A_number = map(int,input().split())
    summ += A*A_number

if total== summ:
    print('Yes')
else:
    print('No')

