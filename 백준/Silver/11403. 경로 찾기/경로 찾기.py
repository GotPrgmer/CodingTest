Num = int(input())
arr = [list(map(int,input().split())) for _ in range(Num)]

# 0 1, 1 2, 2 0
Q = []
visited = set()
for i in range(Num):
    for j in range(Num):
        if arr[i][j]:
            Q.append((i,j))
            while Q:
                current = Q.pop(0)
                if current not in visited:
                    visited.add(current)
                    for des in range(len(arr[current[1]])):
                        if arr[current[1]][des]:
                            Q.append((current[0],des))

for i in visited:
    arr[i[0]][i[1]] = 1
for i in range(Num):
    for j in range(Num):
        print(arr[i][j],end=' ')
    print()



