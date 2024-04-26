import sys

def input():
    return sys.stdin.readline().rstrip()

string_input= input()
idx = int(input())
print(string_input[idx-1])