def solution(s):    
    number = ['zero','one','two','three','four','five','six','seven','eight','nine']

    for i in range(len(s)):
        for j in range(10):
            s = s.replace(number[j],str(j))
    return int(s)