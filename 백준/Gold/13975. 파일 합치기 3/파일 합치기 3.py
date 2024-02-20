# 파일들을 합친것도 하나의 파일로 생각한다면
# 그 파일도 파일의 리스트에 포함된다고 생각함
# 그렇게 하고 예제를 풀어봤더니 최소 비용이 나와서 시도

import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

def sol():
    ans = 0
    while len(q) != 1:
        num1 = heapq.heappop(q)
        num2 = heapq.heappop(q)
        ans += num1 + num2
        heapq.heappush(q,num1+num2)
    return ans




T = int(input())
q = []
for _ in range(T):
    K = int(input())
    q = list(map(int,input().split()))
    heapq.heapify(q)
    print(sol())

