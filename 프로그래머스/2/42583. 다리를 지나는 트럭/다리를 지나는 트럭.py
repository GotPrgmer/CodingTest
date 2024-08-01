from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = deque([0]*bridge_length)
    truck_weights = deque(truck_weights)
    cur_weight = 0
    while len(truck_weights)>0:
        time += 1
        cur_weight -= bridge.popleft()
        #트럭을 출발시켜도 되는가?
        if cur_weight + truck_weights[0] <= weight:
            cur_weight += truck_weights[0]
            bridge.append(truck_weights.popleft())
        #못넣으면 0으로 채우기
        else:
            bridge.append(0)

    time += bridge_length




    return time