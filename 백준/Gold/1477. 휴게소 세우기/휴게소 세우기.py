import sys

def input():
    return sys.stdin.readline().rstrip()

N, M, L = map(int,input().split())
location = [0]+list(map(int,input().split()))+[L]
location.sort()

start = 1
end = L - 1
mid = 0
ans = L
while start<=end:
    mid = (start+end)//2
    #mid체크
    cnt = N
    for i0 in range(1,len(location)):
        if (location[i0] - location[i0-1]) > mid:
            if (location[i0] - location[i0-1])%mid == 0:
                cnt += (location[i0] - location[i0-1])//mid - 1
            else:
                cnt += (location[i0] - location[i0-1])//mid

    if cnt < M+N:
        ans = min(ans, mid)
        end = mid - 1

    elif cnt == M+N:
        ans = min(ans, mid)
        end = mid - 1
    else:
        start = mid + 1


print(ans)

