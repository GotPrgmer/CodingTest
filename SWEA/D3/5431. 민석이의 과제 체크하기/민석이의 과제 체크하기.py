T = int(input())

for tc in range(1, T + 1):
    N, K = map(int,input().split())
    students = list(map(int,input().split()))
    total = []
    ans = []

    for i in range(1, N+1):
        total.append(i)
    for j in range(len(total)):
        if total[j] not in students:
            ans.append(total[j])


    ans.sort()

    print(f'#{tc}',end = ' ')
    for i in range(len(ans)):
        print(ans[i],end=' ')
    print()