import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
max_num = 0
imos_dict = dict()
for _ in range(N):
    s, e = map(int,input().split())
    imos_dict[s] = imos_dict.get(s, 0) + 1
    imos_dict[e] = imos_dict.get(e, 0) - 1

current = 0
max_cnt = 0
period = [-1,-1]
flag = 0
for i0 in sorted(imos_dict.keys()):
    current += imos_dict[i0]
    if current > max_cnt:
        max_cnt = current
        period[0] = i0
        flag = 1
    elif current < max_cnt and flag:
        period[1] = i0
        flag = 0

print(max_cnt)
print(*period)

