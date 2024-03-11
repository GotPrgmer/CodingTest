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
    for i in range(1, N+1):
        if start < last[i]:
            temp.append(i)

    maxDist = 0
    minIdx = 1
    for j in range(1, N+1):
        v = 101
        for k in temp:
            v = min(abs(j-k), v)
        if v == 0:
            continue
        if v > maxDist:
            maxDist = v
            minIdx = j

    last[minIdx] = end
    info[minIdx].append([start, end])

result = 720
for i in range(len(info[P])):
    s, e = info[P][i]
    si, sj, ei, ej = s//100, s%100, e//100, e%100
    if ej - sj < 0:
        val = (ei - si - 1) * 60 + (60 - (sj - ej))
    else:
        val = (ei - si) * 60 + (ej - sj)
    result -= val
print(result)