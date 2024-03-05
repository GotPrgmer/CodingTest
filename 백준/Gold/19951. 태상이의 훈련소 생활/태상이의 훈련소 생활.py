import sys

def input():
    return sys.stdin.readline().rstrip()

#누적합을 통해서 리스트에 해당 인덱스, 마지막 인덱스 +1(존재하다면) - 절대값 추가해서
# 누적합을 구한 후 원래의 리스트와 합침

def sol():
    # 누적합하기
    for idx in range(1,N):
        acc[idx] += acc[idx-1]

    #원래 리스트와 더하기
    for idx in range(N):
        height_lst[idx] += acc[idx]

    return height_lst

N, M = map(int,input().split())

#연병장 높이 입력
height_lst = list(map(int,input().split()))

#누적합 리스트
acc = [0]*N

for _ in range(M):
    # 시작 인덱스, 끝 인덱스, 변화 흙 양
    a, b, k = map(int,input().split())
    acc[a-1] += k
    if b+1 <= len(height_lst):
        acc[b] -= k



print(*sol())


