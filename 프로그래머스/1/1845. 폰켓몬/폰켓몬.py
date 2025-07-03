def solution(nums):
    kind = set(nums)
    
    return min(len(kind),len(nums)/2)