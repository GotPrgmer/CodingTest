import sys

input = sys.stdin.readline
w, h = map(int,input().split())

now_r, now_c = map(int,input().split())
t = int(input())

if (now_r + t) % w == 0:
    if ((now_r + t) // w)%2:
        now_r= w

    else:
        now_r = 0
else:
    if ((now_r + t) // w)%2:
        now_r= w-(now_r + t) %w

    else:
        now_r = (now_r + t) %w

if (now_c + t) % h == 0:
    if ((now_c + t) // h)%2:
        now_c= h

    else:
        now_c = 0
else:
    if ((now_c + t) // h)%2:
        now_c= h-(now_c + t) %h

    else:
        now_c = (now_c + t) %h

print(now_r, now_c)