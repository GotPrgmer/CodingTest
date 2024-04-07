import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

def sol(current,left,right,process):
    if current == ''.join(N) and visited[process] == 0:
        visited[process] = 1
    else:
        if left > 0:
            sol(N[left-1]+current,left-1,right,process+current)

        if right < len(N) - 1:
            sol(current+N[right+1], left, right+1, process + current)



visited = defaultdict(int)
N = list(input())
for i in range(len(N)):
    sol(N[i],i,i,N[i])

print(len(visited.keys()))