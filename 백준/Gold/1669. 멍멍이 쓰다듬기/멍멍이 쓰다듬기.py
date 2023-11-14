import sys

def input():
    return sys.stdin.readline().rstrip()

X, Y = map(int,input().split())

diff = Y - X
mid = 2
if diff <= 2:
    print(diff)
# 3이상
else:
    while True:
        if diff <= mid**2:
            if diff == mid ** 2:
                print(2*mid -1)
                break
            elif diff >= mid**2 - mid +1:
                print(2*(mid-1)+1)
                break
            else:
                print(2*(mid-1))
                break
        else:
            mid += 1