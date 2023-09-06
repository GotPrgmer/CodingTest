import sys
def input():
    return sys.stdin.readline().rstrip()

n, k = map(int,input().split())

#가로 0에서 n번까지 두자

start = 0
end = n // 2
total_cut =0
while start <= end:
    mid = (start + end) // 2

    #체크
    horizon_cut = mid + 1
    vertical_cut = (n-mid) + 1
    total_cut = horizon_cut * vertical_cut
    if total_cut < k:
        start = mid + 1
    elif total_cut > k:
        end = mid - 1
    else:
        break

if total_cut == k:
    print("YES")
else:
    print("NO")