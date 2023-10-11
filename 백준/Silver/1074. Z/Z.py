import sys
sys.setrecursionlimit(10**6)

def input():
    return sys.stdin.readline().rstrip()

def z(r,c,l,cnt):
    if l != 2:
        #2사분면
        if r<=goal_r<r+l//2 and c<=goal_c<c+l//2:
            z(r,c,l//2,cnt)
        # 1사분면
        elif r<=goal_r<r+l//2 and c+l//2<=goal_c:

            z(r, c + l // 2, l // 2,cnt+((l//2)**2)*1)
        #3사분면
        elif r+l//2<=goal_r and c<=goal_c<c+l//2:

            z(r + l // 2, c, l // 2,cnt+((l // 2) ** 2) * 2)

        #4사분면
        elif r+l//2<=goal_r and c+l//2<=goal_c:

            z(r+l//2,c+l//2,l//2,cnt + ((l // 2) ** 2) * 3)
    else:
        for d in range(4):
            cnt += 1
            if r+d_r[d] == goal_r and c+d_c[d] == goal_c:
                print(cnt)
                return




d_r = (0,0,1,1)
d_c = (0,1,0,1)

N, goal_r, goal_c = map(int,input().split())

z(0,0,2**N,-1)
