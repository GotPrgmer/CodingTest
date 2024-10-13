import heapq
def solution(phone_book):
    heapq.heapify(phone_book)
    answer = True
    while phone_book:
        cur = heapq.heappop(phone_book)
        if not phone_book:
            break
        
        elif len(cur)<=len(phone_book[0]):
            #길이만큼 for문
            compare = phone_book[0]
            for i in range(len(cur)):
                if cur[i] != compare[i]:
                    break
            else:
                answer = False
    return answer