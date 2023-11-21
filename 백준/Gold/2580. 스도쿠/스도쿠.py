import sys

def input():
    return sys.stdin.readline().rstrip()

#row체크
def checkRow(row,checkNum):
    for num in range(9):
        if checkNum == sudoku[row][num]:
            return False
    return True

#col체크
def checkCol(col,checkNum):
    for num in range(9):
        if checkNum == sudoku[num][col]:
            return False
    return True

#사각형 체크
def Rectangle(row,col,checkNum):
    row_three = row//3*3
    col_three = col//3*3

    for r in range(row_three,row_three+3):
        for c in range(col_three,col_three+3):
            if checkNum == sudoku[r][c]:
                return False
    return True

def backtracking(idx):
    if idx == len(blank):
        for num in range(9):
            print(*sudoku[num])
        exit(0)

    for i in range(1,10):
        r_idx = blank[idx][0]
        c_idx = blank[idx][1]
        if checkRow(r_idx,i) and checkCol(c_idx,i) and Rectangle(r_idx,c_idx,i):
            sudoku[r_idx][c_idx] = i
            backtracking(idx+1)
            sudoku[r_idx][c_idx] = 0

sudoku = []

for _ in range(9):
    sudoku.append(list(map(int,input().split())))

blank = []
for i0 in range(9):
    for i1 in range(9):
        if sudoku[i0][i1] == 0:
            blank.append((i0,i1))

backtracking(0)