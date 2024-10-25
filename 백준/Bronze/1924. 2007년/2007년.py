import sys

def input():
    return sys.stdin.readline().rstrip()

x, y = map(int,input().split(' '))

month_day = [31,28,31,30,31,30,31,31,30,31,30,31]
date = ['SUN','MON','TUE','WED','THU','FRI','SAT']
days = 0
for i in range(x-1):
    days += month_day[i]
days += y
print(date[days%7])