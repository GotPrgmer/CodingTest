import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()


N, M = map(int,input().split())
num_true, *humans = map(int,input().split())
humans = set(humans)
graph  = []
for _ in range(1,M+1):
    num_party, *party_humans = map(int,input().split())
    graph.append(set(party_humans))

for _ in range(M):
    for party in graph:
        if party & humans:
            humans = humans.union(party)
cnt = 0
for party in graph:
    if party & humans:
        continue
    cnt += 1
print(cnt)