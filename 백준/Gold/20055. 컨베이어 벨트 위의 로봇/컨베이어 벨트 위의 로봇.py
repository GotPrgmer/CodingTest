import sys

def input():
    return sys.stdin.readline().rstrip()



#벨트 한칸 이동
def move(info):
    new_line = [info[-1]] + info[0:2*N-1]
    if new_line[N-1][1]:
        new_line[N-1][1] -= 1
    return new_line
#로봇 이동시키기
def robot_move():
    for i in range(2*N-2,-1,-1):
        #i가 2*N-1이 아니라면 다음항이 있다는 거니깐...
        #현재항에 로봇이 있는지랑 다음항에 로봇이 없고 내구도가 1이상이어야함
        #그럴 때 다음항으로 로봇을 옮기고 내구도를 1깎자, 그리고 현재항에서 로봇을 없애자
        if info[i][1] and (not info[i+1][1]) and info[i+1][0]:
            info[i+1][1] += 1
            info[i+1][0] -= 1
            info[i][1] -= 1
            if i + 1 == N - 1:
                info[i+1][1] -= 1

#로봇 올리기
def robot_up():
    if info[0][0]>0:
        #내구도가 1이상이면
        info[0][0] -= 1
        info[0][1] += 1

#0의 개수 판별
def zero_count():
    zero_count_current = 0
    for i in range(2*N):
        if not info[i][0]:
            zero_count_current += 1
    return zero_count_current

N, K = map(int,input().split())
robots = list(map(int,input().split()))

#robot공간 추가
info = []
for i in range(2*N):
    info.append([robots[i],0])

zero_current = 0
cycle = 0
while True:
    cycle += 1
    info = move(info)
    robot_move()
    robot_up()
    if zero_count() >= K:
        break

print(cycle)