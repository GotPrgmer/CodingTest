def solution(s):
    str_lst = list(s)
    ans = []
    flag = 0
    for ch in range(len(str_lst)):
        if str_lst[ch] == " ":
            flag = 0
            continue
        else:
            if flag == 0:
                flag = 1
                if str_lst[ch].isdigit():
                    continue
                else:
                    str_lst[ch] = str_lst[ch].upper()
            #첫글자가 아니라면
            else:
                str_lst[ch] = str_lst[ch].lower()
                
        
    return ''.join(str_lst)