import sys
from collections import deque
from collections import defaultdict


def input():
    return sys.stdin.readline().rstrip()

N, d, k, c = map(int,input().split())
circular_que = []

#초밥 입력
for _ in range(N):
    chobab = int(input())
    circular_que.append(chobab)
#k개의 큐를 슬라이딩 윈도우로 돌면서 중복되지 않는 초밥의 개수
moving_que = deque(circular_que[0:k])
store = defaultdict(int)
cnt = 0
max_cnt = 0

for i in moving_que:
    if i != c:
        if store[i] == 0:
            cnt += 1
        store[i] += 1

max_cnt = max(max_cnt,cnt)

for i0 in range(len(circular_que)):
    #i0 빼고 c가 아니면 store와 max_cnt에 영향
    erase = moving_que.popleft()
    if erase != c:
        store[erase] -= 1
        if store[erase] == 0:
            cnt -= 1

    #-1부터 시작하는 리스트인덱스의 값을 deque에 추가하고 c가 아니면 store와 max_cnt에 영향
    plus = circular_que[-(N-(i0+k))]
    moving_que.append(plus)

    if plus != c:
        store[plus] += 1
        if store[plus] == 1:
            cnt += 1

    max_cnt = max(max_cnt,cnt)


print(max_cnt + 1)