import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()

def dfs(x):
    
    isCycle.add(x)
    cycleTemp.append(x)

    next = students[x]

    #next가 cycleTemp에 있으면 사이클 안에 들어가 있는것이라서
    #사이클 발생
    if next in isCycle:
        if next in cycleTemp:
             cycleStudent.extend(cycleTemp[cycleTemp.index(next):])
        return
    dfs(next)


T = int(input())
for _ in range(T):
    n = int(input())
    students = [0]+list(map(int,input().split()))
    isCycle = set()
    cycleStudent = []

    for i in range(1,n+1):
        if i not in isCycle:
            cycleTemp = []
            dfs(i)
    print(n-len(cycleStudent))

