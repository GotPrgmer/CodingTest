# (10(0000000000)1111111111)*?
# 1부터 시작하면 반드시 00은 한번 있어야 함
# 1로 시작하면 1로 끝나야함
# 00이 나오면 1을 앞에 붙이자
# 0으로 시작하면 1이 바로 다음에 와야함

import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()

string_stream = input()

def sol():

    q = deque(string_stream)
    while q:
        # 첫번째 유형인지
        if q[0] == '1':
            #처음 00 제거하기
            if len(q) < 3 or q[1] != '0' or q[2] != '0':
                return 'NOISE'
            q.popleft()
            while q and q[0] == '0':
                q.popleft()
            if not q:
                return 'NOISE'

            #1제거하기
            cnt = 0
            while q and q[0] == '1':
                q.popleft()
                cnt += 1
            if len(q)>= 3 and cnt >= 2 and q[0] == '0' and q[1] =='0':
                q.appendleft('1')

        else:
            if len(q) < 2 or q[1] != '1':
                return 'NOISE'
            q.popleft()
            q.popleft()

    return 'SUBMARINE'

print(sol())