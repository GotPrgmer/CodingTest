
N = int(input())
time_list = list(map(int,input().split()))
time_list.sort()
ans = 0
tmp = 0
for i1 in range(N):
    tmp += time_list[i1]
    ans += tmp
print(ans)

