T = int(input())

for tc in range(1, T + 1):
    N = int(input()) # 버스 노선의 수
    total_route = []
    solo = []
    check = []
    cnt = 0

    total_bus = [0]*5001


    for i in range(1, N + 1):

        A, B = map(int,input().split())
        for j in range(A, B + 1):
            total_bus[j] += 1
    P = int(input())
    for i in range(P):
        check.append(int(input()))
    print(f'#{tc}',end= ' ')
    for i in check:
        print(total_bus[i],end=' ')
    print()
'''
1
2
1 3
2 5
5
1
2
3
4
5
'''