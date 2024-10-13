import heapq
def solution(participant, completion):
    heapq.heapify(completion)
    heapq.heapify(participant)
    ans = ""
    while participant:
        cur_part = heapq.heappop(participant)
        if completion:
            cur_com = heapq.heappop(completion)
            if cur_part != cur_com:
                ans = cur_part
                break
            else:
                continue
        else:
            ans = cur_part
            break
        
        
    return ans