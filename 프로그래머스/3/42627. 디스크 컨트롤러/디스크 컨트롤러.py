import heapq
def solution(jobs):
    now = 0
    task = 0
    start = -1
    q = []
    answer = 0
    while task<len(jobs):
        for job in jobs:
            if start < job[0]<=now:

                heapq.heappush(q,[job[1],job[0]])
        if q:
            cur = heapq.heappop(q)
            start = now
            now +=cur[0]
            answer += now -cur[1]
            task += 1
        else:
            now += 1
    return answer//len(jobs)