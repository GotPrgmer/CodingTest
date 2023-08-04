import sys

def input():
    return sys.stdin.readline().rstrip()


H, W = map(int,input().split())

block_list = list(map(int,input().split()))

ans = 0
for i0 in range(1, W-1):
    left_max = max(block_list[:i0])
    right_max = max(block_list[i0+1:])

    chosen_depth = min(left_max,right_max)

    if block_list[i0] < chosen_depth:
        ans += chosen_depth - block_list[i0]

print(ans)





