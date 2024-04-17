def solution(s):
    str_lst = list(map(int,s.split()))
    min_v = min(str_lst)
    max_v = max(str_lst)
    return str(min_v)+" "+str(max_v)