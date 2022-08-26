T = int(input())

for tc in range(1, T + 1):
    N, K = map(int,input().split())
    score = list(map(int,input().split()))
    score_sum = []
    score.sort()
    for _ in range(K):
        score_sum.append(score.pop())
    print(f'#{tc} {sum(score_sum)}')