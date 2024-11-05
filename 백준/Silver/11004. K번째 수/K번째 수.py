import sys

def input():
    return sys.stdin.readline().rstrip()

N, K = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()
print(lst[K-1])