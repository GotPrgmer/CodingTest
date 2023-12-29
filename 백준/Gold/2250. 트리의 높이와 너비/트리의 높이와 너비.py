import sys

def input():
    return sys.stdin.readline().rstrip()

N= int(input())
graph  = [[0,0] for _ in range(N+1)]
row = [list() for _ in range(N+1)]
root_num = [0] * (N+1)
col = 1

for _ in range(N):
    num, l, r = map(int,input().split())
    graph[num] = [l,r]
    root_num[num] += 1
    if l != -1 : root_num[l] += 1
    if r != -1 : root_num[r] += 1

def find_root():
    return root_num.index(1)

# 같은 레벨이 있는 노드 기록(중위 순회로 기록)
def level_record(node, level):
    global col
    left, right = graph[node]
    #왼쪽 자식이 있으면 왼쪽으로
    if graph[node][0] != -1:
        level_record(left,level+1)

    row[level].append(col)
    col += 1

    #오른쪽 자식이 있으면 오른쪽으로
    if graph[node][1] != -1:
        level_record(right,level+1)


def max_find():
    level = 1
    max_diff =  max(row[1]) - min(row[1]) + 1
    for idx in range(2,N+1):
        if not row[idx]:
            break
        diff = max(row[idx]) - min(row[idx]) + 1
        if max_diff < diff:
            max_diff = diff
            level = idx
    print(level,max_diff)

level_record(find_root(),1)
max_find()