square_col, square_row = map(int,input().split())

square = [[0]*(square_row+1) for _ in range(square_col + 1)]
row_cut = [0]
col_cut = [0]
cut = 0
ans = 0

T = int(input())

for number in range(T):
    which_one, cut = map(int,input().split())

    if which_one == 0:
        row_cut.append(cut)
    else:
        col_cut.append(cut)
row_cut.append(square_row)
col_cut.append(square_col)

row_cut.sort()
col_cut.sort()

for i in range(1,len(row_cut)):
    for j in range(1,len(col_cut)):
        if ans < (row_cut[i]-row_cut[i-1]) * (col_cut[j]-col_cut[j-1]):
            ans = (row_cut[i]-row_cut[i-1]) * (col_cut[j]-col_cut[j-1])


print(ans)


