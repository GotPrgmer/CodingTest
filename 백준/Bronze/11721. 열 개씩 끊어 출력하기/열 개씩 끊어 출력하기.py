import sys

def input():
    return sys.stdin.readline().rstrip()
input_str = list(input())
for idx,a in enumerate(input_str):
    if idx%10 == 0 and idx != 0:
        print()
        print(input_str[idx],end='')
    else:
        print(input_str[idx],end='')
