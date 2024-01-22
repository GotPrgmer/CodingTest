# A에서 B로 가는 최소비용
# 우선 다익스트라 이용하는거 아닐까?
#
#
# 출발도시 번호 도착 도시 한번타는데 필요한 비용
#
# 1 -> 2 2
# 1 -> 3 3
# 1 -> 4 1
# 1 -> 5 10
#
# 모든 도시쌍에서 최소비용이면 바로 플로이드 와샬인데?
# 시작 도시 도착 도시를 연결하는 노선이 하나가 아닐수 있다는 말은
# 같은 노선이라도 비용이 다양하게 발생할 수 있다는 거 아닌가?
# 그럼 더더욱 dp인 플로이들 와샬이라고 생각함
#n이 100개니까 n^3승해도 되겠다!

import sys
from collections import defaultdict


def input():
    return sys.stdin.readline().rstrip()

n = int(input())
m = int(input())

#도시들의 정보를 그래프로 기록... 하면 안될듯 여러개의 정보가 있으므로...
#각 도시의 정보를 힙으로 저장해서 최소비용인것들을 빼는 걸로?
#굳이 나머지를 다 갖고 잇어야하나? 하나만 가지고 있어도 되니까 최소비용을 갱신하는 방향이 좋겠다.
#그렇다면... defaultdict로 해서 최소 비용을 갱신하다라고 하자.

#우선 도시 정보들 입력 받자
bus_info = defaultdict(int)
for _ in range(m):
    a, b, cost = map(int,input().split())
    if bus_info[(a,b)] != 0:
        bus_info[(a,b)] = min(bus_info[(a,b)],cost)
    else:
        bus_info[(a,b)] = cost

dp = [[float('INF')] * (n+1) for _ in range(n+1)]
#플로이드 와샬돌리기 하자
#우선 값 초기화
for city in range(1,n+1):
    for to_city in range(1,n+1):
        if bus_info[(city,to_city)] != 0:
            dp[city][to_city] = bus_info[(city,to_city)]

#플로이드 와샬의 중간값들을 어떻게 배치해야하나...
#a와 b가 있으면 c를 사이사이에 넣어야 한다
#바깥에 있을경우 같은 c가 a c b를 갱신한다.
#a -> c 그리고 c -> b
#근데 도시가 연결되어있지 않으면...?
#갈 수 없는 경우도 존재하네...
#플로이드 와샬은... 어떻게 진전이 생기지?

#밖에 있으면?
# 1 -> 1 -> 2
# 1 -> 1 -> 3
# 1 -> 1 -> 4
# 2 -> 1 -> 1
# 2 -> 1 -> 3
# 2 -> 1 -> 4

#1부터 시작하니까 스무스 한데?

# 중간에 잇으면...
# 1 -> 3 -> 4
# 1 -> 2 -> 4
# 이렇게 바로 되면 안될거같은데
# 1부터 한다고 정말 스텝바이 스텝으로 될까?

#마지막에 있으면...
# 1 -> c -> 2인데 c가 계속 달라짐
# 주의할 점은 최신의 정보가 업데이트 되지 않은 상태에서 업데이트 할때 잘안되지않을까?
# 업데이트 하는 순서를 알아야할거같은데
# 잘 모르겠다 찾아봐야지
# 거처가는 기점을 기준으로 테이블을 갱신한단다.
# 그럼 당연하게 가장 바깥에 있는게 맞다.
# 초기화를 무한대로 해주고 거처가는 기점을 기준으로 업데이트 하는 것을 꼭 잊지말자


for c in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            if a != b:
                if dp[a][c] == 0 or dp[c][b] == 0:
                    continue
                else:
                    dp[a][b] = min(dp[a][c]+dp[c][b],dp[a][b])
#inf인 부분을 0으로 고쳐서?

for a in range(1,n+1):
    for th in range(1,n+1):
        if th != n:
            if dp[a][th] == float('INF'):
                print(0,end=' ')
            else:
                print(dp[a][th],end=' ')
        else:
            if dp[a][th] == float('INF'):
                print(0)
            else:
                print(dp[a][th])
