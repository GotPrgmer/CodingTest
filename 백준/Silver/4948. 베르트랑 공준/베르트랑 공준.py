#입력이 0이 나올때까지 input을 계속 받아야함.
import sys
input = sys.stdin.readline
count=0


num = int(input())
while 1:
    if(num == 0):
        break
    else:

        a = [False,False] + [True]*(2*(num)+1)
        primes= []
        #처음 넣은 수를 제외하고는 2x그 수 부터 +그 수를 for문에 넣어서 돌리면서 False값을 만들어
        for i in range(2,(2*num)+1):
            if a[i]:
                primes.append(i)
                for j in range(2*i,(2*num)+1,i):
                    a[j]=False
        for i in primes:
            if (i>num):
                count+=1
        print(count)
        count=0
        num = int(input())