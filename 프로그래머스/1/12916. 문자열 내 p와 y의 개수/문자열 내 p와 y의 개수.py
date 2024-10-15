def solution(s):
    p_cnt = 0
    y_cnt = 0
    for i in s:
        if 'p' == i.lower():
            p_cnt += 1
        elif 'y' == i.lower():
            y_cnt += 1
    if p_cnt == y_cnt :
        return True
    elif p_cnt != y_cnt:
        return False
    else:
        return True