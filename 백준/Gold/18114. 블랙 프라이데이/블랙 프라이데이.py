import sys

def input():
    return sys.stdin.readline().rstrip()

N, C = map(int,input().split())
w_lst = list(map(int,input().split()))
w_lst.sort()

def binary(start,end,obj):
    s = start
    e = end
    while s <= e:
        mid = (s + e) // 2
        if w_lst[mid] == obj:
            return 1
        elif w_lst[mid] > obj:
            e = mid - 1
            continue
        else:
            s = mid + 1
            continue
    return 0

def sol() :

    #1개로 되는지
    if C in w_lst:
        return 1
    s = 0
    e = N - 1
    while s < e:
        #양쪽에 있는걸 합해서 비교
        total = w_lst[s] + w_lst[e]
        # C보다 크면 e를 줄이자
        if total > C:
            e -= 1
            continue
        elif total == C:
            return 1
        # total이 C보다 작으므로 수 하나가 더 필요함(3개)
        else:
            difference = C - total
            # 중복으로 선택하지 못하므로
            if w_lst[s] != difference and w_lst[e] != difference and binary(s,e,difference):
                return 1
            # 발견되지 않았고 total을 증가시켜서 다른 diff를 위한 여정을 떠남
            s += 1

if sol() :
    print(1)
else:
    print(0)


