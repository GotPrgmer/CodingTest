import sys
input = sys.stdin.readline

num = int(input())
final = num
cnt = 0

while True:
    a = num // 10
    b = num % 10
    c = (a+b) % 10
    num = (b * 10) + c

    cnt = cnt + 1
    if(num== final):
        break;
print(cnt)