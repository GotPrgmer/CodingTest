import math
import sys

def input():
    return sys.stdin.readline().rstrip()

K = int(input())

# 자릿수
cnt = int(math.log2(K+1))

obj = K - (2**cnt - 1)
real_num = bin(obj)[2:]

final_num = "0"*(cnt - len(real_num))+real_num

ans = ""
for i in final_num:
    if i == "0":
        ans += "4"
    elif i == "1":
        ans += "7"
print(ans)
