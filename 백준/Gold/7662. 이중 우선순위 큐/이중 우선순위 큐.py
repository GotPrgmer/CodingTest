import sys
import heapq

def input():
    return sys.stdin.readline().rstrip()

T = int(input())
ans = []
for _ in range(T):
    k = int(input())
    max_pq = []
    min_pq = []
    check_key = [False]*(1_000_001)
    for i2 in range(k):
        oper, n = input().split()
        n = int(n)
        if oper == 'I':
            heapq.heappush(max_pq,(-1*n,i2))
            heapq.heappush(min_pq, (n,i2))
            check_key[i2] = True

        else:

            if n == 1:
                while max_pq and not check_key[max_pq[0][-1]]:
                    heapq.heappop(max_pq)
                if max_pq:
                    check_key[max_pq[0][-1]] = False
                    heapq.heappop(max_pq)

                else:
                    continue
            else:
                while min_pq and not check_key[min_pq[0][-1]]:
                    heapq.heappop(min_pq)
                if min_pq:
                    check_key[min_pq[0][-1]] = False
                    heapq.heappop(min_pq)
                else:
                    continue
    while min_pq and not check_key[min_pq[0][-1]]:
        heapq.heappop(min_pq)
    while max_pq and not check_key[max_pq[0][-1]]:
        heapq.heappop(max_pq)

    if min_pq and max_pq:
        print(-max_pq[0][0], min_pq[0][0])

    else:
        print('EMPTY')


