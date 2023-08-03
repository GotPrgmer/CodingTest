import sys
def input():
    return sys.stdin.readline()

N, K = map(int,input().split())
num_list = list(map(int,input().split()))



odd_cnt = 0
ans = 0
start, end = 0, 0
size = 0
flag = 1

for s in range(N):
    while odd_cnt <= K and flag:
        if num_list[end]%2:
            if odd_cnt == K:
                break
            odd_cnt +=1
        size += 1
        if end == N -1:
            flag = 0
            break
        end += 1
    if ans < size - odd_cnt:
        ans = size - odd_cnt
    if num_list[s] % 2:
        odd_cnt -= 1
    size -= 1
print(ans)