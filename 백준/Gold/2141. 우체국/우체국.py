import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

town_info = []
for _ in range(N):
    X, A = map(int,input().split())
    town_info.append((X,A))
town_info.sort()


#누적합 구하기
summation = []
for town in town_info:
    if len(summation):
        summation.append(summation[-1] + town[1])
    else:
        summation.append(town[1])

goal = round(summation[-1]/2)

for town in range(len(summation)):
    if summation[town] >= goal:
        print(town_info[town][0])
        break