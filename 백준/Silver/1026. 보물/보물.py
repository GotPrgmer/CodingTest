Num = int(input())
A = list(map(int,input().split()))
A.sort(reverse=True)
B = list(map(int,input().split()))
B.sort()
S=0
for i in range(len(A)):
    S += A[i]*B[i]
print(S)