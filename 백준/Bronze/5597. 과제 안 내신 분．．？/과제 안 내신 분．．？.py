import sys
def input():
    return sys.stdin.readline().rstrip()


nums = []
num_visited= [False]*(31)
for _ in range(28):
    num = int(input())
    num_visited[num] = True

for i in range(1, 31):
    if not num_visited[i]:
        print(i)