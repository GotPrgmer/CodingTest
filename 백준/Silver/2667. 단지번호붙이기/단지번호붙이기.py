big = int(input())
aprt = [list(map(int,input())) for _ in range(big)]
d_r = [-1,0,1,0]
d_c = [0,1,0,-1]
visited = set()
ans_list = []
dong = 0

for i in range(big):
    for j in range(big):
        if aprt[i][j] == 0:
            continue
        elif aprt[i][j] and ((i,j) not in visited):
            Q = [(i, j)]
            cnt = 0
            while Q:
                current = Q.pop(0)
                if current not in visited:
                    visited.add(current)
                    cnt += 1
                # for d in range(4):
                #     if 0<=current[0]+d_r[d]<big and 0<=current[1]+d_c[d]<big and aprt[current[0]+d_r[d]][current[1]+d_c[d]] == 1 and (current[0]+d_r[d],current[1]+d_c[d]) not in visited :
                #         Q.append((current[0]+d_r[d],current[1]+d_c[d]))
                    if 0 <= current[0] + d_r[0] < big and 0 <= current[1] + d_c[0] < big and aprt[current[0] + d_r[0]][
                        current[1] + d_c[0]] == 1 and (current[0] + d_r[0], current[1] + d_c[0]) not in visited:
                        Q.append((current[0] + d_r[0], current[1] + d_c[0]))
                    if 0 <= current[0] + d_r[1] < big and 0 <= current[1] + d_c[1] < big and aprt[current[0] + d_r[1]][
                        current[1] + d_c[1]] == 1 and (current[0] + d_r[1], current[1] + d_c[1]) not in visited:
                        Q.append((current[0] + d_r[1], current[1] + d_c[1]))
                    if 0 <= current[0] + d_r[2] < big and 0 <= current[1] + d_c[2] < big and aprt[current[0] + d_r[2]][
                        current[1] + d_c[2]] == 1 and (current[0] + d_r[2], current[1] + d_c[2]) not in visited:
                        Q.append((current[0] + d_r[2], current[1] + d_c[2]))
                    if 0 <= current[0] + d_r[3] < big and 0 <= current[1] + d_c[3] < big and aprt[current[0] + d_r[3]][
                        current[1] + d_c[3]] == 1 and (current[0] + d_r[3], current[1] + d_c[3]) not in visited:
                        Q.append((current[0] + d_r[3], current[1] + d_c[3]))
            if cnt:
                ans_list.append(cnt)
                dong += 1
print(dong)
ans_list.sort()
for i in ans_list:
    print(i)