import sys
from collections import deque

def input():
    return sys.stdin.readline().rstrip()


def topology():
    q = deque([])

    for i0 in range(1, N + 1):
        if in_dimension[i0] == 0:
            q.append(i0)
    while q:
        current = q.popleft()
        for node in list(subjects[current]):
            in_dimension[node] -= 1
            if in_dimension[node] == 0:
                dp[node] = dp[current] + 1
                q.append(node)

N, M = map(int,input().split())
subjects = [[] for _ in range(N+1)]
in_dimension = [0]*(N+1)
dp = [1]*(N+1)




for _ in range(M):
    node, con = map(int,input().split())
    subjects[node].append(con)
    in_dimension[con] += 1





topology()
print(*dp[1:])






