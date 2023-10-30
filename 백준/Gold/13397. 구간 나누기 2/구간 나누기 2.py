import sys
from itertools import combinations


def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())
lst = list(map(int,input().split()))


#리스트 길이가 한개일 때는 그 한개의 값이 정답이 된다.
if N == 1:
    print(0)
else:
    s = 0
    e = max(lst)
    mid = (s+e)//2
    ans = e
    while s <= e:
        mid = (s+e)//2
        #점검 현재 최소의 최댓값으로 건널 수 있을까?
        first = 0
        second = 0
        min_value = lst[first]
        max_value = lst[first]
        cnt = 1
        flag = 0
        while True:
            min_value = min(lst[second],min_value)
            max_value = max(lst[second],max_value)
            if max_value - min_value <= mid:
                if second + 1 < N:
                    second += 1
                else:
                    break
            else:
                first = second
                if cnt + 1 <= M:
                    cnt += 1
                    min_value = lst[first]
                    max_value = lst[first]
                else:
                    flag = 1
                    break

        #good
        if flag != 1:
            e = mid - 1
            ans = min(ans,mid)
        else:
            s = mid + 1
    print(ans)