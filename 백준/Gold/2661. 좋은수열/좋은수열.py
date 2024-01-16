import sys

def solve(s, l):
    for d in range(1, l//2 + 1):
        right = int(s[l-d:])
        left = int(s[l-2*d:l-d])
        if right == left:
            return

    if l == n:
        print(int(s))
        exit()

    for i in ['1', '2', '3']:
        solve(s+i, l+1)

n = int(input())
solve('1', 1)




