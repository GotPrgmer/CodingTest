import sys
from collections import defaultdict
import heapq

def input():
    return sys.stdin.readline().rstrip()

def sol():
    #1인것들 찾기
    #집합을 순회하면서 1을 찾기
    q = []
    for node in range(1,M+1):
        #임시로 순서를 기억하는 리스트

        if indegree[node][0] == 0:
            heapq.heappush(q,node)
            indegree[node][1] = 1

    #힙에서 하나씩 빼서 현재 있는 관계 수에서 하나씩 빼서 임시 순서를 갱신해줌
    #그리고 0이 되는 순간에 힙영역에 (최종 순서, 시작노드, 끝노드)
    #하지만 끝노드가 없는 경우는 끝에 도달했으므로 return
    while q:

        cur_node = heapq.heappop(q)
        for next_node in graph[cur_node]:

            #하나빼기
            indegree[next_node][0] -= 1
            if indegree[next_node][1] < indegree[cur_node][1]:
                indegree[next_node][1] = indegree[cur_node][1]
                indegree[next_node][2] = 1
            elif indegree[next_node][1] == indegree[cur_node][1]:
                indegree[next_node][2] += 1

            if indegree[next_node][0] == 0:
                #0이 됨
                if indegree[next_node][2] > 1:
                    indegree[next_node][1] += 1
                heapq.heappush(q,next_node)
    return indegree[M][1]


T = int(input())

for _ in range(1,T+1):
    K, M, P = map(int,input().split())

    #간선이 1인것들을 찾기 위한 집합
    indegree = [[0, 0, 0] for _ in range(M+1)]
    graph = [[] for _ in range(M+1)]

    for _ in range(P):
        #간선입력
        A, B = map(int,input().split())
        indegree[B][0] += 1
        graph[A].append(B)

    print(K,sol())