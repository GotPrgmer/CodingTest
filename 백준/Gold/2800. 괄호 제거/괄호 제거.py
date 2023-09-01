import sys

from itertools import combinations
from copy import deepcopy

def input():
    return sys.stdin.readline().rstrip()

expression = list(map(str,input()))

stack = []
pair_parenthesis = []
ans = set()

# tmp에 괄호 순서쌍 넣기
for i0 in range(len(expression)):
    if expression[i0] == "(":
        stack.append(i0)
    elif expression[i0] == ")":
        pair_parenthesis.append((stack.pop(),i0))

# 괄호제거해서 문자열 넣기
for i1 in range(1,len(pair_parenthesis)+1):
    #괄호 순서쌍 얻기
    pair = list(combinations(pair_parenthesis,i1))
    #실제 리스트에서 해당 순서쌍에 해당하는 괄호 빼기

    for i2 in pair:
        tmp = deepcopy(expression)
        for i3 in i2:
            tmp[i3[0]] = ""
            tmp[i3[1]] = ""
        ans.add("".join(tmp))
ans = sorted(list(ans))
for i4 in ans:
    print(i4)
