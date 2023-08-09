import sys
def input():
    return sys.stdin.readline().rstrip()
N, M = map(int,input().split())

time = []
max_time = 0

for _ in range(N):
    this_time = int(input())
    time.append(this_time)
    if max_time < this_time:
        max_time = this_time

start = 0
end = max_time * M
ans = 0
while start <= end:
    mid = (start + end) // 2
    tmp = 0
    for t in time:
        tmp += mid // t

    if tmp >= M:
        end = mid - 1
        ans = mid

    else:
        start = mid + 1
print(ans)

