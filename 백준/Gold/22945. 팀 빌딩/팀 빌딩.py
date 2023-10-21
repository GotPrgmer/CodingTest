import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
ability = list(map(int,input().split()))

start = 0
end = len(ability) - 1
ans = 0
while start < end:
    ans = max(ans,(end - start - 1) * min(ability[start],ability[end]))

    if ability[start] == ability[end]:
        end -= 1
    else:
        if ability[start] < ability[end]:
            start += 1
        else:
            end -= 1
print(ans)