import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
balls = [0]*N
for _ in range(M):
    i,j,k = map(int,input().split())
    for action in range(i,j+1):
        balls[action-1] = k

print(*balls)