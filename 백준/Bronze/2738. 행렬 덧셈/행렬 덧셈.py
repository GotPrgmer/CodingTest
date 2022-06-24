row,column=map(int,input().split())
if (row==0)or(column==0):
    exit()
answer=[ [0] * column for _ in range(row)]
for i in range(row):
    lst = list(map(int,input().split()))
    for j in range(len(lst)):
        answer[i][j]+=lst[j]

for i in range(row):
    lst = list(map(int,input().split()))
    for j in range(len(lst)):
        answer[i][j]+=lst[j]

for i in range(row):
    for j in range(column):
        print(answer[i][j],end=' ')
    if i != row:print()
