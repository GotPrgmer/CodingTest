def solution(gems):
    dic = {gems[0]:1}
    s = 0
    e = 0
    answer = [0,len(gems)-1]
    total_num = len(set(gems))
    while s<=e<len(gems):
        if len(dic) < total_num:
            e += 1
            if e == len(gems):
                break
            dic[gems[e]] = dic.get(gems[e],0)+1
        else:
            if (e-s+1) < answer[1]-answer[0]+1:
                answer[0],answer[1]= s, e
            if dic.get(gems[s])==1:
                del dic[gems[s]]
            else:
                dic[gems[s]] -= 1
            s += 1
    answer[0] +=1
    answer[1] +=1
    return answer