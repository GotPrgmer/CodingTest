for _ in range(10):
    tc, e = map(int,input().split())
    edge_route = list(map(int,input().split()))

    adj_list= [[] for _ in range(100)]
    #99에서 출발하여 경로를 구했을 때
    #그 안에 0이 있는지 확인
    for i in range(len(edge_route)):
        if i % 2 == 0:
            adj_list[edge_route[i]].append(edge_route[i + 1])
        else:
            continue
    stack = [0]
    visited = []
    while stack:
        current = stack.pop()
        if current not in visited:
            visited.append(current)
        for destination in adj_list[current]:
            if destination not in visited:
                stack.append(destination)
    print(f'#{tc} {int(99 in visited)}')



