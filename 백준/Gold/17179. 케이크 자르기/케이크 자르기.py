import sys

def input():
    return sys.stdin.readline().rstrip()

def binary_search(mid):
    cnt, tmp = 0,0
    for cut in cut_lst:
        if cut - tmp >= mid:
            cnt += 1
            tmp = cut
    return cnt



def sol():
    for num in num_lst:
        start, end = 1, L
        ans = 0

        while start <= end:
            mid = (start + end) // 2
            cnt = binary_search(mid)

            if cnt > num:
                start = mid + 1
                ans = max(ans,mid)
            else:
                end = mid - 1
        print(ans)


N, M , L = map(int,input().split())

cut_lst = [int(input()) for _ in range(M)] + [L]
num_lst = [int(input()) for _ in range(N)]

sol()

