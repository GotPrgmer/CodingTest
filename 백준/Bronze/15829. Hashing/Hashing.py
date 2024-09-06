import sys

def input():
    return sys.stdin.readline().rstrip()

l = input()
ans= 0
input_data = list(input())
for idx,i in enumerate(input_data):
    ans += (ord(i)-96)*31**idx
print(ans%1234567891)