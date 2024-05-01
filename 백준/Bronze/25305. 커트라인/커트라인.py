import sys

def input():
    return sys.stdin.readline().rstrip()

N, k = map(int,input().split())
scores = list(map(int,input().split()))
scores.sort()
print(min(scores[-k:]))