import sys
def input():
    return sys.stdin.readline().rstrip()

d_r = (0,-1,0,1)
d_c = (1,0,-1,0)

N = int(input())
square_board = [[0]*(101) for _ in range(101)]


def transform(old):
    new = []
    #현재 방향 + 1
    for i0 in old:
        new.append((i0+1)%4)

    new.reverse()
    old.extend(new)
    return old

for _ in range(N):
    x, y, d, g= map(int,input().split())
    old_g = [d]
    for _ in range(g):
        old_g = transform(old_g)
    square_board[y][x] = 1
    for mv in old_g:
        y += d_r[mv]
        x += d_c[mv]
        square_board[y][x] = 1
#사각형 찾기
def find_square(coor):
    check_r = (0,1,0)
    check_c = (1,0,-1)
    cor_r = coor[0]
    cor_c = coor[1]
    if square_board[cor_r][cor_c]:
        for d0 in range(3):
            cor_r += check_r[d0]
            cor_c += check_c[d0]
            if square_board[cor_r][cor_c] == 1:
                continue
            else:
                return False
        return True
    else:
        return False


ans = 0
for r in range(100):
    for c in range(100):
        if find_square((r,c)):
            ans += 1
        else:
            continue


print(ans)