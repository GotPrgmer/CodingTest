import sys

def binary_search(N, N_list, start, end):
    if(start>end): return 0
    mid = (start+end)//2
    if(N==N_list[mid]): return 1
    elif(N<N_list[mid]): return binary_search(N, N_list, start, mid-1)
    elif(N>N_list[mid]): return binary_search(N, N_list, mid+1, end)

N = int(sys.stdin.readline())
N_list = list(map(int, sys.stdin.readline().split()))
N_list = sorted(N_list)

M = int(sys.stdin.readline())
M_list = list(map(int, sys.stdin.readline().split()))

for temp in M_list:
    if (binary_search(temp,N_list,0,N-1)) : print("1", end=" ")
    else : print("0", end=" ")