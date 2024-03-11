import sys

def input():
    return sys.stdin.readline().rstrip()

N, T, P = map(int, input().split())
times = []
for _ in range(T):
    start, end = map(str, input().strip().split())
    times.append([int(start), int(end)])

times.sort(key = lambda x:(x[0], x[1]))

last = [0] * (N+1)
info = [[] for _ in range(N+1)]

info[1].append(times[0])
last[1] = times[0][1]

for t in range(1, T):
    start, end = times[t]
    temp = []
    # 어떤 자리들이 지금 이용불가능인지
    # 나보다 먼저온 사람에 의해 선점이 되었고, 내가 이용할 시점에는 그사람도 이용중이다.
    # 퇴실시간이 내가 온 시간보다 나중인 자리중에 내가 이용 가능한 좌석은 없다.
    # 내가 온 타이밍에 온시간보다 늦게까지 선점이 되어있다는 것은
    # 나보다 먼저 왔기에 현재 기준으로 내가 차지할 수 없는 자리이다.
    # 그런의미에서 소팅을 했고, last를 사용하는 것임.
    for i in range(1, N+1):
        if start < last[i]:
            temp.append(i)

    # 각 자리와 차지 할 수 없는 자리의 차이가 가장 작은 것들 중 차이가 가장 큰 것을 추출
    maxDiff = 0
    minIdx = 1
    for j in range(1, N+1):
        v = 101
        for k in temp:
            v = min(abs(j-k), v)

        # 차지할 수 없는 자리와 체크하는 자리와 겹쳐서 통과시킴
        if v == 0:
            continue

        # 차이가 큰 것을 갱신
        if v > maxDiff:
            maxDiff = v
            minIdx = j

    #해당 사용자가 사용할 자리를 선점
    last[minIdx] = end
    info[minIdx].append([start, end])

result = 720
#각 자리의 사용자 수 만큼 사용한 시간을 계산
for i in range(len(info[P])):
    s, e = info[P][i]
    si, sj, ei, ej = s//100, s%100, e//100, e%100
    if ej < sj:
        val = (ei - si - 1) * 60 + (60 - (sj - ej))
    else:
        val = (ei - si) * 60 + (ej - sj)
    result -= val
print(result)

