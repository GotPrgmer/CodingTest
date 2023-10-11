import sys

def input():
    return sys.stdin.readline().rstrip()

def positioning(player,score):
    global max_score
    if player == 11:
        max_score = max(score,max_score)
        return
    else:
        for i0 in range(11):
            if visited[i0] or not ability[player][i0]:
                continue
            else:
                visited[i0] = 1
                position[player] = i0
                positioning(player+1,score+ability[player][i0])
                position[player] = 0
                visited[i0] = 0


C = int(input())
for _ in range(C):
    ability = [list(map(int,input().split())) for _ in range(11)]
    max_score = 0
    position = [0] * 11
    visited = [0] * 11
    positioning(0,0)
    print(max_score)

