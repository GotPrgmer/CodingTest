import heapq


def solution(scoville, K):
    #힙을 써서 첫번째원소가 K미만이면 두개를 꺼내서 섞고 다시 힙에 추가해주는 방식
    heapq.heapify(scoville)
    cnt = 0
    while scoville[0]<K and len(scoville)>=2:
        cur1,cur2 = heapq.heappop(scoville), heapq.heappop(scoville)
        new = cur1+cur2*2
        heapq.heappush(scoville,new)
        cnt +=1
    if len(scoville)==1 and scoville[0]<K:
        return -1
    else:
        return cnt