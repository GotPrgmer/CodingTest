from collections import deque
N, K = map(int,input().split())

start = K
tmp = 0
ans = []
yose_list = deque([i+1 for i in range(N) ])
while len(ans) != N:
    #회전하기
    yose_list.rotate(-K)
    ans.append(yose_list.pop())


print("<",end="")
for i in range(N):
    if i != 0:
        print(", "+str(ans[i]),end="")
    else:
        print(ans[0],end="")
print(">",end="")