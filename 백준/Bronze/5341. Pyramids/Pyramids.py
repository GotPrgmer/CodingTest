import sys

def input():
    return sys.stdin.readline().rstrip()

while True:
    num = int(input())
    if num == 0:
        break
    print((1+num)*(num//2) + int(bool(num%2))*(1+(num//2)))