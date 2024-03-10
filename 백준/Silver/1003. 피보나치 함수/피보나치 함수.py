import sys

def input():
    return sys.stdin.readline().rstrip()

def fibonaci(x):
    global cnt_1
    global cnt_0
    if memoi[x] != -1:
        if x == 1:
            cnt_1 += 1
        elif x == 0:
            cnt_0 += 1
        return memoi[x]

    else:
        memoi[x] = fibonaci(x-2) + fibonaci(x-1)
        return

T = int(input())
memoi = [[1,0],[0,1]]
for _ in range(T):
    N = int(input())
    for remember in range(len(memoi),N+1):
        memoi.append([memoi[remember-2][0]+memoi[remember-1][0],memoi[remember-2][1]+memoi[remember-1][1]])
    print(memoi[N][0], memoi[N][1])