def solution(numbers, target):
    cnt = 0
    def dfs(x,value):
        nonlocal cnt
        if x== len(numbers):
            if value == target:
                cnt += 1
                return
            else:
                return
        dfs(x+1,value-numbers[x])
        dfs(x+1,value+numbers[x])
            
    
    dfs(0,0)
    return cnt