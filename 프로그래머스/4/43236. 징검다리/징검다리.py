from itertools import combinations
# 0 2 11 14 17 21 25
# 2 9 3 3 4 4
# 2 3 3 4 4 9
# 3일때 3미만 인것 두개이상 나오면 안됨 그러지만 않으면 3이 1개이상 나와야함(이분탐색 조건으로 가능)
# 2개의 면제권이 주어지는데 그걸 다 안채워도 통과임
# TTTTTFFFFFF s를 원함
def solution(distance, rocks, n):
    cur = 0
    rocks.sort()
    distance_set = set()
    for r in rocks+[distance]:
        distance_set.add(abs(cur-r))
        cur =r
    distance_set = list(distance_set)
    s = 1
    e = distance+1
    while s+1<e:
        m = (s+e)//2
        cnt = 0
        cur = 0
        for d in rocks+[distance]:
            if m>d-cur:
                cnt += 1
                if cnt >n:
                    break
                else:
                    continue
            else:
                cur = d
        if cnt > n:
            e = m
        else:
            s = m
    return s
    
    
    return answer

