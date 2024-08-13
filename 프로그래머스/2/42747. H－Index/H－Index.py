import math
def solution(citations):
    #h를 정하고 h번이상 인용된 논문이 h개 이상이고 h번 이하 인용된 것이 n-h개라면 그 h의 최대값이 H-index
    #0 1 3 5 6
    citations.sort()
    max_value = max(citations)
    print()
    h = -1
    for i in range(max_value,-1,-1):
        goal = i
        s = 0
        e = len(citations)-1
        tmp = math.inf
        while s<=e:
            m =(s+e)//2
            if citations[m]>=goal:
                tmp = min(m,tmp)
                e = m-1
            else:
                s = m+1
        #h-index조건에 맞는지
        #전체 길이 나온 인덱스
        if tmp != -1:
            if len(citations) - tmp >= goal:
                h = max(h,goal)
                
    print(h)            
        
    return h