import sys

def input():
    return sys.stdin.readline().rstrip()

N= str(input())

cnts = []
min_vlue = 10
max_vlue = -1
def solve(N,this_cnt):
    ans = 0
    global min_vlue
    global max_vlue
    #한자리 수 일때
    if len(N) == 1:
        if int(N) % 2 == 1:
            ans += 1
        cnts.append(this_cnt+ans)
        return

    elif len(N) == 2:
        for i0 in N:
            if int(i0) % 2 == 1:
                ans += 1
        solve(str(int(N[0])+int(N[1])),ans+this_cnt)
    else:
        for i0 in N:
            if int(i0) % 2 == 1:
                ans += 1

        for i0 in range(1,len(N)):
            for i1 in range(i0+1,len(N)):
                solve(str(int(N[0:i0])+int(N[i0:i1])+int(N[i1:])),ans+this_cnt)

solve(N,0)
print(min(cnts),max(cnts))


