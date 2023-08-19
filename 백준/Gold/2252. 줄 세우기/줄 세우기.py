import sys
from collections import deque


def input():
    return sys.stdin.readline().rstrip()

N, M =  map(int,input().split())


students = [[] for _ in range(N+1)]
in_demension = [0]*(N+1)
result = []

def topologySort():
    global in_demension
    q = deque([])

    #진입차수가 0인것들을 q에 넣기
    for i0 in range(1,N+1):
        if in_demension[i0] == 0:
            q.append(i0)

    #위상정렬 돌리기
    for _ in range(N):
        #도중에 비어있으면 사이클이 있으니 에러
        if not q:
            return print(-1)

        #빼서 결과에 넣기
        current = q.popleft()
        result.append(current)

        #빼낸 노드와 연결된 노드들의 진입차수를 확인해서 0인것들을 넣어주기

        for node in students[current]:
            if in_demension[node] >= 1:
                in_demension[node] -= 1
                if in_demension[node] == 0:
                    q.append(node)




#각 노드에 연결된 노드들을 리스트로 관리
#진입차수를 in_demension으로 관리
for _ in range(M):
    node, con = map(int,input().split())
    students[node].append(con)
    in_demension[con] += 1

topologySort()
print(*result)