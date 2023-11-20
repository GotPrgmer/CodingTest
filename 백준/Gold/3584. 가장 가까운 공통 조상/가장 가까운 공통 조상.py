import sys

def input():
    return sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    N = int(input())
    parent = [0 for _ in range(N+1)]
    for _ in range(N-1):
        A, B = map(int,input().split())
        parent[B] = A
    m,n = map(int,input().split())

    first_start = m
    parent_a = []
    while True:
        #root가 아닌것임
        if parent[first_start] != first_start:
            parent_a.append(first_start)
            first_start = parent[first_start]
        else:
            parent_a.append(first_start)
            break

    second_start = n
    parent_b = []
    while True:
        # root가 아닌것임
        if parent[second_start] != second_start:
            parent_b.append(second_start)
            second_start = parent[second_start]
        else:
            parent_b.append(second_start)
            break

    start_idx = -1
    while True:
        if parent_a[start_idx] == parent_b[start_idx]:
            start_idx -= 1
            #더 나아갈 인덱스가 있는가?
            if abs(start_idx) <= len(parent_a) and abs(start_idx) <= len(parent_b):
                continue
            else:
                print(parent_a[start_idx+1])
                break
        else:
            print(parent_a[start_idx+1])
            break

