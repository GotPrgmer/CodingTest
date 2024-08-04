def solution(prices):
    answer = []
    for p1 in range(len(prices)):
        tmp = 0
        for p2 in range(p1+1,len(prices)):
            if prices[p1]<=prices[p2]:
                tmp += 1
            else:
                tmp += 1
                break
        answer.append(tmp)
    return answer