import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

def sol():
    global ans
    q = deque([(0, N)])
    while q:
        for _ in range(len(q)):
            s, e = q.popleft()

            if e <= s + 1:
                continue
            mid = (s + e) // 2

            #앞부분 변경
            for fp in range(s,mid):
                monkeys[fp] = 'A'

            #뒷부분 변경
            for bp in range(mid,e):
                monkeys[bp] = 'B'

            q.append((s,mid))
            q.append((mid,e))
        ans.add(''.join(monkeys))


N = int(input())

monkeys = ['A']*N

ans = set()
sol()
for ans_lst in ans:
    print(''.join(ans_lst))

for _ in range(7 - len(ans)):
    print("A" + "B"*(N-1))