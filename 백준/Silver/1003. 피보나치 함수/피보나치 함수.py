import sys

def input():
    return sys.stdin.readline().rstrip()

T = int(input())
memoi = [[1,0],[0,1]]
for _ in range(T):
    N = int(input())
    for remember in range(len(memoi),N+1):
        memoi.append([memoi[remember-2][0]+memoi[remember-1][0],memoi[remember-2][1]+memoi[remember-1][1]])
    print(memoi[N][0], memoi[N][1])