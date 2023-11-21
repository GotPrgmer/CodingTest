import sys

def input():
    return sys.stdin.readline().rstrip()

Ipv6 = list(map(str,input().split(":")))

#블록카운트
index = 0
ans = ['' for _ in range(8)]
flag = 0

for i0 in range(len(Ipv6)):
    if len(Ipv6[i0])==4:
        ans[index] = Ipv6[i0]
        index += 1

    elif len(Ipv6[i0]) > 0:
        ans[index] = '0' * (4 - len(Ipv6[i0])) + Ipv6[i0]
        index += 1
    else:
        if flag == 0:
            for j in range(8 - len(Ipv6) + 1):
                ans[index] = '0000'
                index += 1
            flag = 1
        else:
            ans[index] = '0000'
            index += 1

print(':'.join(ans))
