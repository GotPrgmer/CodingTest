import sys

def input():
    return sys.stdin.readline().rstrip()


def horizon():
    max_len = 0
    new_matrix = []
    for r in range(len(matrix)):
        new_cnt, new_row = [],[]
        visited = set()
        for itm in set(matrix[r]):
            if itm not in visited and itm != 0:
                new_cnt.append([itm, matrix[r].count(itm)])
                visited.add(itm)
        new_cnt.sort(key=lambda x: (x[1], x[0]))
        for i in new_cnt:
            new_row.extend(i)

        new_matrix.append(new_row)

        #풀어헤치고 최대값 갱신

        max_len = max(len(new_row),max_len)
    #0채우기
    for r in range(len(new_matrix)):
        if max_len > len(new_matrix[r]):
            new_matrix[r].extend([0]*(max_len-len(new_matrix[r])))
    return new_matrix




r, c, k = map(int,input().split())
matrix = []
for _ in range(3):
    matrix.append(list(map(int,input().split())))
cnt = 0
flag = 0
while True:
    if cnt>100:
        flag = 1
        break

    if 0<=r-1<len(matrix) and 0<=c-1<len(matrix[0]):
        if matrix[r-1][c-1] == k:
            break

        # 행연산
    if len(matrix) >= len(matrix[0]):
        matrix = horizon()
    # 열연산
    else:
        matrix = list(map(list, zip(*matrix)))
        matrix = horizon()
        matrix = list(map(list, zip(*matrix)))
    cnt += 1

if flag == 1:
    print(-1)
else:
    print(cnt)