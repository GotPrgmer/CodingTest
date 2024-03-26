import sys
from itertools import permutations

def input():
    return sys.stdin.readline().rstrip()



N = int(input())
num_lst = list(map(int, input().split()))
ans = 0
num_perm = permutations(num_lst)
P, Q = map(int, input().split())
op = ["+"]*P + ["*"]*Q
oper_perm = set(permutations(op,N-1))

for num in num_perm:
    for perm in oper_perm:
        arr = []
        cnt = 0
        temp = num[0]
        for oper in perm:
            if oper == "+":
                temp += num[cnt+1]
                cnt += 1
            elif oper == "*":
                arr.append(temp)
                temp = num[cnt+1]
                cnt += 1
        arr.append(temp)
        result = arr[0]
        for idx in range(1,len(arr)):
            result *= arr[idx]
        ans = max(result,ans)

print(ans)