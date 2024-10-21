from collections import deque
import heapq
def solution(food_times, k):
    answer = -1
    q = []
    for idx,f in enumerate(food_times):
        heapq.heappush(q,[f,idx+1])
    food_cnt = len(food_times)
    previous = 0
    while q:
        if k>=(q[0][0]-previous)*food_cnt:
            k -= (q[0][0]-previous)*food_cnt
            food_cnt -= 1

            previous, _ = heapq.heappop(q)
        else:
            idx = k%food_cnt
            q.sort(key = lambda x:x[1])
            return q[idx][1]
    return answer