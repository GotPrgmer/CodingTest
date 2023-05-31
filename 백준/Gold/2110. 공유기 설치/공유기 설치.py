
N, C = map(int,input().split())
share_list = []
for _ in range(N):
    share_list.append(int(input()))

share_list.sort()

if C == 2:
    print(share_list[-1]-share_list[0])
else:
    start = 1
    end = share_list[-1] - share_list[0]
    ans = 0
    while (start < end):
        mid = (end + start) // 2
        current = share_list[0]
        count = 1
        for i1 in range(1,len(share_list)):
            if (share_list[i1] - current) >=mid:
                count += 1
                current = share_list[i1]
        if count >= C:
            ans = mid
            start = mid+1
        elif count < C:
            end = mid
    print(ans)




