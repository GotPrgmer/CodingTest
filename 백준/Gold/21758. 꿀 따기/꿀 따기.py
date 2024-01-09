import sys

def input():
    return sys.stdin.readline().rstrip()

N = int(input())

positions = list(map(int,input().split()))
total = sum(positions)

honey = 0
previous_sum = 0
first_case = 2*(total - positions[0])
# 꿀벌 도착지
for bumblebee in range(1,N - 1):
    previous_sum += positions[bumblebee]
    honey = max(honey,first_case - (previous_sum + positions[bumblebee]))

previous_sum = 0
second_case = 2*(total - positions[-1])
# 도착지 꿀
for bumblebee in range(N-2,0,-1):
    previous_sum += positions[bumblebee]
    honey = max(honey, second_case - (previous_sum + positions[bumblebee]))

# 꿀이 벌의 중간에 있을 때
third_case = total - (positions[0] + positions[-1])
max_value = max(positions[1:N-1])
honey = max(honey, third_case + max_value)

print(honey)