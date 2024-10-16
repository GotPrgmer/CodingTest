def solution(a, b):
    small = min(a,b)
    big = max(a,b)
    answer = 0
    for i in range(small,big+1):
        answer += i
        
    return answer