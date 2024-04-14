import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
balls = [i for i in range(N+1)]
for _ in range(M):
    i, j = map(int,input().split())
    balls[j],balls[i] = balls[i],balls[j]
print(*balls[1:])