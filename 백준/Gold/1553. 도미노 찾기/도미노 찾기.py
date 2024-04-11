import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()
d_r = (0,1)
d_c = (1,0)

def sol(r,c):
    if r == 8:
        return 1
    count = 0
    nr = r
    nc = c + 1
    if nc == 7:
        nr = r + 1
        nc = 0
    if visited[r][c]:
        return sol(nr,nc)
    else:
        now = domino[r][c]
        visited[r][c] = True
        for d in range(2):
            n_r = r + d_r[d]
            n_c = c + d_c[d]
            if n_r in range(8) and n_c in range(7):
                next_num = domino[n_r][n_c]
                if not visited[n_r][n_c] and not visited_domino[(now,next_num)]:
                    visited_domino[(now, next_num)] = 1
                    visited_domino[(next_num, now)] = 1
                    visited[n_r][n_c] = True

                    count += sol(nr,nc)

                    visited_domino[(now, next_num)] = 0
                    visited_domino[(next_num, now)] = 0
                    visited[n_r][n_c] = False
        visited[r][c] = False
        return count



domino = [list(input()) for _ in range(8)]
visited = [[False]*7 for _ in range(8)]
visited_domino = defaultdict(int)

print(sol(0,0))