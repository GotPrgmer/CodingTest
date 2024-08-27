import sys

def input():
    return sys.stdin.readline().rstrip()

N, M, x, y, k = map(int,input().split())
d_r = [0,0,-1,1]
d_c = [1,-1,0,0]

#위, 뒤, 우, 좌, 전, 아래
die= [0,0,0,0,0,0]
#좌, 우, 아래, 위
#[0,1,2,3,4,5]일때 매칭되는 패턴
patterns=[[3,1,0,5,4,2],[2,1,5,0,4,3],[4,0,2,3,5,1],[1,5,2,3,0,4]]
entire_map = []
for _ in range(N):
    entire_map.append(list(map(int,input().split())))

cmds = list(map(int,input().split()))
#현재 포인트
cur_r, cur_c = [x,y]
for c in cmds:
    #명령대로 움직여서 주사위 수정하고
    cur_pattern = patterns[c-1]

    # print(c,cur_r+d_r[c-1],cur_c+d_c[c-1])
    #범위 내
    if cur_r+d_r[c-1] in range(N) and cur_c+d_c[c-1] in range(M):
        tmp = die[:]
        for idx in range(len(cur_pattern)):
            die[idx] = tmp[cur_pattern[idx]]

        cur_r =(cur_r + d_r[c-1])
        cur_c =(cur_c + d_c[c-1])
        # print(c)
        # print(cur_r,cur_c,d_r[c-1],d_c[c-1])
        #지도 위 내용 파악해서 0이면 주사위 바닥 수가 지도에 저장
        map_value = entire_map[cur_r][cur_c]
        # print(entire_map)
        # print("위",die)
        if map_value == 0:
            entire_map[cur_r][cur_c] = die[5]

        #지도 위 내용이 0이 아니면 주사위 바닥 수가 수정됨
        else:
            die[5] = entire_map[cur_r][cur_c]
            entire_map[cur_r][cur_c] = 0

        #주사위 윗면 출력
        print(die[0])
        # print("아래",die)

    #범위 아님
    else:
        # print("망함",c)
        continue
