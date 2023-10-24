import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

T= int(input())

def backtracking(cnt):
    if cnt == len(entire_string):
        print(''.join(current_string))
        return

    for alpha in alphabet_store:
        if alphabet_store[alpha]:
            alphabet_store[alpha] -= 1
            current_string.append(alpha)
            backtracking(cnt+1)
            current_string.pop()
            alphabet_store[alpha] += 1


for _ in range(T):
    #문자입력받기
    entire_string = sorted(list(map(str,input())))
    alphabet_store = defaultdict(int)
    current_string = []
    for i0 in entire_string:
        alphabet_store[i0] += 1
    backtracking(0)