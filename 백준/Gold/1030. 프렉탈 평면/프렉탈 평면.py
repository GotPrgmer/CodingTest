import sys
input = sys.stdin.readline

def check_black(l, point):
    x,y = point # 현재 탐색중인 좌표
    center = l//N # 검정색 칸의 범위
    if l == 1:
        return 0
    if center * (N-K)//2 <= x < center * (N+K)//2 and center * (N-K)//2 <= y < center * (N+K)//2:
        return 1
    x %= center
    y %= center
    return check_black(l//N, [x,y])
s,N,K,R1,R2,C1,C2 = map(int,input().split())
l = N**s # 한 변의 길이


for i in range(R1, R2+1):
    for j in range(C1, C2+1):
        print(check_black(l,[i,j]), end="")
    print()