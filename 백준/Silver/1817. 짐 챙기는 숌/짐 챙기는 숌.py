import sys

def input():
    return sys.stdin.readline().rstrip()

N, M = map(int,input().split())

if N == 0:
    print(0)
else:
    boxes = list(map(int, input().split()))
    s=0
    e=0
    total = 0
    ans = 0
    while s<=e and e<len(boxes):
        if M < total+boxes[e]:
            ans += 1
            s = e
            total = boxes[e]
            e += 1
        else:
            if ans == 0:
                ans += 1
            total += boxes[e]
            e += 1
    print(ans)
