S, C = map(int,input().split())


chicken = []
max_chicken = 0
chicken_sum = 0

for _ in range(S):
    tmp = int(input())
    if max_chicken < tmp:
        max_chicken = tmp
    chicken.append(tmp)
    chicken_sum += tmp

left = 1
right = max_chicken
ans = 0

while left <= right:
    mid = (left + right)//2

    chicken_tmp = 0
    for i0 in range(S):
        chicken_tmp += chicken[i0] // mid

    if chicken_tmp >=  C:
        left = mid+1
        ans = max(ans,mid)
    else:
        right = mid -1

print(chicken_sum - ans*C)



