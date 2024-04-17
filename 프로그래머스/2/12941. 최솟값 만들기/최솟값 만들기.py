def solution(A,B):
    A.sort()
    B.sort(reverse=True)
    ans = 0
    for i in range(len(A)):
        ans += A[i] *B[i]
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

    return ans