import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

N, K = map(int,input().split())


q = deque([(N,0)])
visited = set()
visited.add(N)
if N == 0 and K == 0:
    print(0)
else:
    while q:
        current = q.popleft()
        loc = current[0]
        sec = current[1]
        if loc == K:
            print(sec)
            break
        for d in range(3):
            if d == 0:
                if 100000 >= loc * 2 > 0 and loc * 2 not in visited:
                    q.append((loc * 2, sec))
                    visited.add(loc * 2)
                else:
                    continue
            elif d == 1:
                if 100000 >= loc - 1 >=0 and loc - 1 not in visited:
                    q.append((loc - 1,sec+1))
                    visited.add(loc-1)
                else:
                    continue
            elif d == 2:
                if 100000 >= loc + 1 >=0 and loc + 1 not in visited:
                    q.append((loc + 1,sec+1))
                    visited.add(loc + 1)
                else:
                    continue
