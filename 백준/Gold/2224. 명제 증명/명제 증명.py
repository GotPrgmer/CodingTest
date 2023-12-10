import sys

def input():
    return sys.stdin.readline().rstrip()


# P를 전건 Q를 후건
# 어떤 참인 명제가 주어져, 이 명제는 증명이 되었다.
# P => P라는 명제이므로 전건 과 후건이 같아서 출력하지 않음

N = int(input())
# A인 65부터 z인 122까지 58개이다.
arr = [[0] * 58 for _ in range(58)]

ans = 0
for _ in range(N):
    input_lst = list(map(str,input().split(' ')))
    if input_lst[0] == input_lst[2]:
        continue

    #1개짜리
    if not arr[ord(input_lst[0])-65][ord(input_lst[2])-65]:
        arr[ord(input_lst[0]) - 65][ord(input_lst[2]) - 65] = 1
        ans += 1


#플로이드 와샬로 각 경로를 갈 수 있을 때마다 ans에 1씩 더함
for k in range(58):
    for i in range(58):
        for j in range(58):
            if i != j and not arr[i][j] and arr[i][k] and arr[k][j]:
                arr[i][j] = 1
                ans += 1

print(ans)
for i0 in range(58):
    for i1 in range(58):
        if arr[i0][i1]:
            print(chr(i0+65),"=>",chr(i1+65))
