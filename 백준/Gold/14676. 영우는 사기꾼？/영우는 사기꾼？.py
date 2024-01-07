import sys
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

N, M, K = map(int,input().split())
relation = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
building_num = defaultdict(int)
for _ in range(M):
    X, Y = map(int,input().split())
    relation[X].append(Y)
    indegree[Y] += 1

ans = 'King-God-Emperor'

for _ in range(K):
    build, building = map(int,input().split())
    #건물을 지을때는 위상정렬에 위배되는지 확인
    #위배되지 않는다면 것물현황을 업데이트 하고 건물개수를 업데이트
    #위배된다면 ans에 Lier를 넣어버리고 freeze
    if build == 1:
        #해당 건물의 의존도가 0이어야 건물짓기 가능
        if indegree[building] == 0:
            #건물 지은 다음 해당 건물과 관계된 건물들의 의존도를 1씩 깎는다
            #해당 건물의 개수를 1씩 올림
            building_num[building] += 1
            if building_num[building] == 1:
                for next_node in relation[building]:
                    if indegree[next_node]:
                        indegree[next_node] -= 1
        else:
            # 건물을 짓지 못하면 ans에 Lier넣기
            ans = 'Lier!'

    else:
        #해당 건물의 숫자가 1이상이어야 건물 부수기 가능
        if building_num[building]:
            #건물을 부순다음 건물의 개수 업데이트하고 0이면 해당 건물의 의존도 1씩 올림
            building_num[building] -= 1
            if building_num[building] == 0:
                for next_node in relation[building]:
                    indegree[next_node] += 1
        else:
            ans = 'Lier!'
            #건물을 부수지 못한다면 ans에 Lier넣기
print(ans)