import sys

def input():
    return sys.stdin.readline()

# 건물의 개수
n = int(input())

# 빌딩의 높이들
buildings = list(map(int, input().split()))

# 각 빌딩에서 볼 수 있는 빌딩의 숫자
building_count = [0] * n

# 볼 수 있는 건물중 가장 가까운 빌딩
near_building = [float('INF')] * n

# 왼쪽 -> 오른쪽으로 탐색하면서 현재 빌딩의 높이보다 큰 빌딩들은 담는 stack
left_stack = []

for i, height in enumerate(buildings):
    # 스택에 요소들이 있고 현재 높이보다 낮은 빌딩들은 모두 제거
    while left_stack and buildings[left_stack[-1]] <= height:
        left_stack.pop()

    building_count[i] += len(left_stack)

    # 가장 가까이에 있는 빌딩 갱신
    if left_stack:
        if abs(i - left_stack[-1]) < abs(near_building[i] - i):
            near_building[i] = left_stack[-1]

    left_stack.append(i)

# 오른쪽 -> 왼쪽으로 탐색하면서 현재 빌딩의 높이보다 큰 빌딩을 담는 스택
right_stack = []

for i in range(n - 1, -1, -1):
    height = buildings[i]

    # 스택에 요소들이 있고 현재 높이보다 낮은 빌딩들은 모두 제거
    while right_stack and buildings[right_stack[-1]] <= height:
        right_stack.pop()

    building_count[i] += len(right_stack)

    # 가장 가까이에 있는 빌딩 갱신
    if right_stack:
        if abs(i - right_stack[-1]) < abs(near_building[i] - i):
            near_building[i] = right_stack[-1]

    right_stack.append(i)

for i in range(n):
    # 볼 수 있는 빌딩이 있는 경우
    if building_count[i]:
        print(building_count[i], near_building[i] + 1)
    else:
        print(0)