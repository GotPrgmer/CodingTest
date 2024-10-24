from collections import deque,defaultdict
def solution(n, roads, sources, destination):
    max_num = -1
    rel = defaultdict(list)
    for r in roads:
        a, b = r
        rel[a].append(b)
        rel[b].append(a)
        max_num = max(max_num,max(a,b))
    visited = set()
    source_lst = [[i,0] for i in sources ]
    ans = [-1 for _ in range(max_num+1)]
    def bfs():
        q = deque([(destination,0)])
        while q:
            cur, dist = q.popleft()
            if cur not in visited:
                visited.add(cur)
            else:
                continue
            ans[cur] = dist
            for node in rel[cur]:
                q.append((node,dist+1))
            
    bfs()
    answer = []
    for s in sources:
        answer.append(ans[s])

    return answer