import sys

def input():
    return sys.stdin.readline().rstrip()

def solve(idx,x,cnt):
    if cnt == N:
        visited.add(x)
        return
    for i in range(idx,len(number)):
        x += number[i]
        solve(i,x,cnt+1)
        x -= number[i]


N = int(input())
number = [1,5,10,50]
visited = set()
solve(-1,0,0)
print(len(visited))