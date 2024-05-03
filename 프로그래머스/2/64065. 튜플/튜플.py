import re
def solution(s):
    lst = s.split("}")
    ans_lst = []
    #숫자만 남기기
    for group in lst:
        new_lst = []
        inner_part = re.sub('{','',group).split(",")
        for c in inner_part:
            if c.isnumeric():
                new_lst.append(int(c))
        if new_lst:
            ans_lst.append(new_lst)
    ans_lst.sort(key=lambda x : len(x))
    tmp = set()
    ans = []
    for g in ans_lst:
        for e in g:
            if e not in tmp:
                tmp.add(e)
                ans.append(e)
    
            
    return ans