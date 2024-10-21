import heapq
def find(x):
    return 0
    

def solution(n, costs):
    parents = [i for i in range(n)]

    def find(x):
        nonlocal parents
        if x != parents[x]:
            return find(parents[x])
        else:
            return parents[x]
    def union(x,y):
        nonlocal parents

        x = find(x)
        y = find(y)
        if x< y:
            parents[y] = x
        else:
            parents[x] = y
    graph = []
    for c in costs:
        heapq.heappush(graph,[c[2],c[0],c[1]])
    graph.sort()
    ans = 0
    while graph:
        cur = heapq.heappop(graph)
        print(cur)
        print(parents)
        if find(cur[1]) != find(cur[2]):
            union(cur[1],cur[2])
            ans += cur[0]
        else:
            continue
    print(ans)
        
    answer = 0
    return ans