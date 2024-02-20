import sys

def input():
    return sys.stdin.readline().rstrip()

def sol():

    #투포인터로 양쪽 끝에서 0보다 크면 오른쪽 포인터를 줄이고 작으면 왼쪽 포인터를 줄이기!
    l = 0
    r = len(vlu_lst) - 1
    ans_min = abs(vlu_lst[l]+vlu_lst[r])
    l_ans = vlu_lst[l]
    r_ans = vlu_lst[r]
    while l < r:
        cur = vlu_lst[l]+vlu_lst[r]
        if abs(cur) < ans_min:
            ans_min = abs(cur)
            l_ans = vlu_lst[l]
            r_ans = vlu_lst[r]

        if cur > 0:
            r -= 1
        elif cur < 0:
            l += 1
        else:
            break
    return (l_ans,r_ans)



N = int(input())

vlu_lst = list(map(int,input().split()))

print(*sol())