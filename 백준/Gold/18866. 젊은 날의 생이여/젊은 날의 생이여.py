import sys

input = sys.stdin.read
data = input().strip().split()
index = 0

def getInt():
    global index
    value = int(data[index])
    index += 1
    return value

def getIntList():
    global index
    values = list(map(int, data[index:index+2]))
    index += 2
    return values

INF = 1000000005
L = 1000005

class Day:
    def __init__(self):
        self.happy = 0
        self.sleepy = 0

days = [Day() for _ in range(L)]
youth = [Day() for _ in range(L)]
old = [Day() for _ in range(L)]

def cmp(a, b):
    if a < b:
        return b
    else:
        return a

def main():
    global index
    maxHappy = -1
    minHappy = INF
    maxSleepy = -1
    minSleepy = INF

    N = getInt()
    
    for i in range(1, N + 1):
        days[i].happy, days[i].sleepy = getIntList()

    # youth
    for i in range(1, N + 1):
        if days[i].happy != 0 and days[i].happy < minHappy:
            minHappy = days[i].happy
        if days[i].sleepy != 0 and days[i].sleepy > maxSleepy:
            maxSleepy = days[i].sleepy
        youth[i].happy = minHappy
        youth[i].sleepy = maxSleepy

    # old
    for i in range(N, 0, -1):
        if days[i].happy != 0 and days[i].happy > maxHappy:
            maxHappy = days[i].happy
        if days[i].sleepy != 0 and days[i].sleepy < minSleepy:
            minSleepy = days[i].sleepy
        old[i].happy = maxHappy
        old[i].sleepy = minSleepy

    # 판별 시작
    count = -1
    for k in range(N - 1, 0, -1):  # K는 젊은 날
        youth_happy = youth[k].happy
        youth_sleepy = youth[k].sleepy
        old_happy = old[k + 1].happy
        old_sleepy = old[k + 1].sleepy
        if youth_happy > old_happy and youth_sleepy < old_sleepy:
            count = cmp(count, k)

    print(count)

if __name__ == "__main__":
    main()
