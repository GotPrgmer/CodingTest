import heapq
def dijkstra(start):
    q= []
    cur_cost = [float('inf')] * total_n

    cur_cost[start] = 0
    heapq.heappush(q,(0,start))
    while q:
        cur_dist, cur_point = heapq.heappop(q)
        
        for cost, point in graph[cur_point]:
            new_dist= cur_dist + cost
            if cur_cost[point] > new_dist:
                cur_cost[point] = new_dist
                heapq.heappush(q,(new_dist,point))
                
    return cur_cost
    

def solution(n, s, a, b, fares):
    global total_n
    global graph
    global cur_cost
    total_n = int(n)
    graph = [[] for _ in range(n)]
    #주어진 정보로 graph 입력형성
    for info in fares:
        p1 = info[0] - 1
        p2 = info[1] - 1
        c = info[2]
        graph[p1].append((c,p2))
        graph[p2].append((c,p1))
    s_cost = dijkstra(s-1)
    a_cost = dijkstra(a-1)
    b_cost = dijkstra(b-1)
    ans = float('inf')
    for specific in range(n):
        ans = min(ans,s_cost[specific]+a_cost[specific]+b_cost[specific])

        
    
    return ans