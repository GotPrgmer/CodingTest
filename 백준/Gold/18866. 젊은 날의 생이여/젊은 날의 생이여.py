import sys

def input():
    return sys.stdin.readline().rstrip()

max_happy = 0
min_happy = float('INF')

max_tired = 0
min_tired = float('INF')

N = int(input())

both = []
for i in range(N):
    h, t = map(int,input().split())
    both.append([h,t])

youth = [[0,0] for _ in range(N)]
old = [[0,0] for _ in range(N)]
#젊은 날들을 보면서 행복의 최소값과 피로도의 최댓값 갱신
#젊은 날의 행복의 최소값이 늙은 날의 행복의 최대값보다 커야하고
#젊은 날의 피로 최대값이 늙은 날의 피로의 최소값보다 작아야한다.
#이게 안맞는 부분직전까지가 최대의 젊은 날임

#젊은 날
for i in range(len(both)):
    if both[i][0] != 0:
        min_happy = min(min_happy,both[i][0])
    if both[i][1] != 0:
        max_tired = max(max_tired,both[i][1])
    youth[i][0] = min_happy
    youth[i][1] = max_tired

#늙은 날
for i in range(len(both)-1,-1,-1):
    if both[i][0] != 0:
        max_happy = max(max_happy,both[i][0])

    if both[i][1] != 0:
        min_tired = min(min_tired,both[i][1])

    old[i][0] = max_happy
    old[i][1] = min_tired

#비교
ans = 0
for i in range(N-1):
    #젊 행 소 > 늙 행 대 and 젊 피 대 < 늙 피 소
    if youth[i][0] > old[i+1][0] and youth[i][1] < old[i+1][1]:
        ans =i + 1
if ans == 0:
    ans = -1

print(ans)