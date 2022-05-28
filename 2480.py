def compare(a,b,c):
    #리스트로 a b c를 넣어서
    #어떤 함수로 중복되는 수의 갯수를 센다
    lst= [a,b,c]
    lst = list(map(int,lst))
    cnt = 0
    reward = 0

    if lst[0]==lst[1]:
        if lst[0]==lst[2]: reward = 10000 + lst[0]*1000
        else : reward = 1000 + lst[0]*100
    else:
        if lst[0]==lst[2]: reward = 1000 + lst[0]*100
        elif lst[1]==lst[2] : reward = 1000 + lst[1]*100
        else : reward = max(lst[0],lst[1],lst[2]) * 100
    return reward




a,b,c = input().split()
print(compare(a,b,c))