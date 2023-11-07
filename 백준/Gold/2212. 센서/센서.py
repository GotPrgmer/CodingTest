import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())
K = int(input())

sensor = list(map(int,input().split()))

sensor.sort()

distance_lst = []
for sensor_idx in range(1,len(sensor)):
    distance_lst.append(sensor[sensor_idx] - sensor[sensor_idx-1])

distance_lst.sort()
if K < N:
    for _ in range(K-1):
        distance_lst.pop()
    print(sum(distance_lst))
else:
    print(0)




