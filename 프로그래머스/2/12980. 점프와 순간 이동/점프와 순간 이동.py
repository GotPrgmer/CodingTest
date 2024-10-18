import sys
from collections import deque
def solution(n):
    ans = 0
    while n>=1:
        if n%2== 0:
            n = n/2
            continue
        n -= 1
        ans += 1
    
    return ans