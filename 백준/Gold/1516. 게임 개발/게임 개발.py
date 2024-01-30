# 종족별 균형과 전체 게임 시간 등을 조절하는 부분
# 모든 건물을 짓는데 걸리는 최소시간을 이용해 근사

#어떤 건물 짓기 위해 다른 건물을 먼저 지어야 할수도

# 여러 개의 건물을 동시에 지을 수도 있음

#자원은 무한히, 명령 내리는 시간은 걸리지 않음

#2억

# 1의 시간 10
# 2의 시간 10 필요한 건물 1
# 3의 시간 4 필요한 건물 1
# 4의 시간 4 필요한 건물 3 1
# 5의 시간 3 필요한 건물 3

# 1 - 2
# 1 - 3 - 4
# 1 - 3 - 5

#10
#20
#14
#18
#17

# 각 건물의 연관관계가 0인지 확인하고 + 자기 자신?

# 1 (10 경과)
# 1 3 (14 경과)
# 1 3 5 ( 17 경과)
# 1 3 4 5 ( 18 경과)
# 1 2  (20 경과)

# 1 -> 10 정답 기록
# 그와 연관된 2, 3, 4에 접근
# 힙큐에 또 넣기 [3,4,2]
# 3과 4가 비용이 4인데
# 3부터 들어가면 14를 정답에 기록
# 3과 연관된 4, 5에 접근 [5,4,4,2]
# 5가 들어가면 14 + 3 정답에 기록
# 4가 들어가면 14 + 4 정답에 기록

#어쨌든 건물을 먼저 세워야 하긴해
# 우선 위상정렬로 카운트 t하면서 다 완성되면
# 해당 건물과 연결되어 있는... 건물을 또 시작해주고...
# 그런데 최소 시간이면
# 가장 빠른거 부터 해야하는건가?

# 진행할 수 잇는 건물중에 가장 적게 시간이 걸리는 것들을
# 더해주는 방식?

# 시간이랑 연관관계를 모두 고려해야함
# 연관관계가 풀려있으면 건물 짓기가 가능
# 우선 연관관계를 다 매핑 시켜놓기

# 연관관계 없으면... 모든 건물 큐에 삽입해서 시간순서대로
# 해당 큐에 가장 시간이 오래걸리는 것이 정답이 됨



import sys
from collections import deque, defaultdict
import heapq

def input():
    return sys.stdin.readline().rstrip()

def topology():
    #시간이랑 building_num이랑 같이 튜플로 해시에 넣기
    hq = []
    visited = set()

    #연관관계가 0인것들 스캔해서 힙에 튜플로 넣기
    for relation in range(1,len(rel_num)):
        if not rel_num[relation]:
            heapq.heappush(hq,(time_build[relation],relation))
            ans[relation] = time_build[relation]

    #위상정렬돌리기
    while hq:
        time, build = heapq.heappop(hq)
        if build in visited:
            continue
        else:
            #관련 빌딩들에 들어가서 연관관계를 하나씩 뺀다음 0이면 정답에 기록
            #dp를 이용해서 누적을 시켜서 연관관계의 총합 + 자기자신 인거같음
            #이전에 연관관계에 있는 건물 중 최고로 많이 걸리는 애를 뽑아서 걔랑 자기자신을 더해야함
            #최고로 많이 걸리는 애를 어떻게 구할까?
            #연관된 애들을 계속적으로 누적

            #건설된 애이기 때문에 시간을 누적해 더함
            dp[build] += time
            for this_building in rel[build]:
                rel_num[this_building] -= 1
                # 자기 자신에 대한 누적값과 연관 건물의 시간으로 갱신
                dp[this_building] = max(dp[this_building], dp[build])
                if not rel_num[this_building]:
                    heapq.heappush(hq,(time_build[this_building],this_building))

N = int(input())

#연관관계
rel_num = [0]*(N+1)
rel = [[] for _ in range(N+1)]
#건설시간
time_build = defaultdict(int)

for build in range(1,N+1):
    building = deque(list(map(int,input().split())))
    building.pop()
    #시간을 추출해서 기록
    time = building.popleft()
    time_build[build] = time

    #연관관계 기록
    if building:
        rel_num[build] = len(building)
        for this_build in building:
            rel[this_build].append(build)
ans = [0]*(N+1)
dp = [0]*(N+1)
topology()
for idx in range(1,N+1):
    print(dp[idx])