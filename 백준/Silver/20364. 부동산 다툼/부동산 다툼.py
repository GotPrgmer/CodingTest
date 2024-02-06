# 트리인데...
# 자리를 맞춰버리고 싶은 애를 2로 나누면서
# 0이 될때까지 나눠질 수 있으면
# 해당 숫자를 visited에 추가

import sys

def input():
    return sys.stdin.readline().rstrip()

def sol(x):
    ans = 0
    original_value = x

    while x > 0:
        if x in visited:
            ans = x
        x //= 2
    if ans == 0:
        visited.add(original_value)
    return ans



N, Q = map(int,input().split())
visited = set()

for _ in range(Q):
    this_input = int(input())
    print(sol(this_input))