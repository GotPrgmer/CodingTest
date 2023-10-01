import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
A = list(map(int,input().split()))
A.sort()

if N >= 3:
    result = 2
    for i0 in range(N-2):
        start = i0
        end = start + 2
        while True:
            if A[start] + A[start+1] > A[end]:
                result = max(result,end-(start+1)+2)
                end += 1
                if end == N:
                    break
            else:
                break
    print(result)
else:
    print(N)



