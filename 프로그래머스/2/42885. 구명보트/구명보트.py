def solution(people, limit):
    people.sort()
    ans = 0
    start = 0
    end = len(people)-1
    while start<=end:
        if people[start]+people[end]<=limit:
            ans +=1
            start += 1
            end -= 1
        else:
            end -= 1
            ans += 1
    # if len(people)%2 == 1:
    #     ans += 1
        
    return ans