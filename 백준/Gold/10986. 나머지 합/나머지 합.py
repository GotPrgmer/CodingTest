import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

entire_lst = list(map(int,input().split()))
remain = [0]*(len(entire_lst))
count = [0]*(M)

#누젃합 구하기
remain[0] =entire_lst[0]%M
count[remain[0]] += 1
for i0 in range(1,len(entire_lst)):
    entire_lst[i0] = entire_lst[i0] + entire_lst[i0-1]
    remain[i0] = entire_lst[i0]%M
    count[entire_lst[i0]%M] += 1


ans = count[0]
for i1 in range(M):
    if count[i1] > 1:
        tmp = count[i1]
        ans += tmp*(tmp-1)//2

print(ans)