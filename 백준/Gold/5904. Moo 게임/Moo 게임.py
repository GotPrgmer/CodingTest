import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

def S(left,cur,N):
    prev_L = (left - cur) // 2
    if N <= prev_L: return S(prev_L,cur-1,N)
    elif N> prev_L + cur : return S(prev_L,cur-1,N-prev_L-cur)
    else: return 'o' if N - prev_L - 1 else 'm'
#N이 나오는 시점 구하기
start = 0
tmp = 3
while tmp < N:
    start += 1
    tmp = 2*tmp + start+3

this_string = S(tmp,start+3,N)
print(this_string)