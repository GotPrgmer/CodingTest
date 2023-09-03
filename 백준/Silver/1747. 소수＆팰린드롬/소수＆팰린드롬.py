import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

check = [False,False] + [True]*(N+1000000-1)

#에라토스테네스
for i0 in range(2, (N+1000000)//2+1):
    if check[i0] == True:
        for i1 in range(i0*2,N+1000000+1,i0):
            check[i1] = False

#패랜드롬 체크
def palindrome(num):
    num_to_str = str(num)
    reverse_str = ''.join(reversed(num_to_str))
    if num_to_str == reverse_str:
        return True
    else:
        return False

for i2 in range(N,N+1000000+1):
    if check[i2] == True:
        if palindrome(i2) == True:
            print(i2)
            break
