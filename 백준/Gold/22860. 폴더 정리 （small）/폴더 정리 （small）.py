# 한 폴더 아래에 같은 이름의 파일이 두개 이상 있으면 안됨
# main 하위에 같은 폴더가 두개 이상 존재하면 안됨
#

import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)
def input():
    return sys.stdin.readline().rstrip()

#경로 맨 마지막 끝이 들어감
def sol(folder):
    file_cnt = 0
    file_set = set()
    #해당 카테고리에서 폴더면 하위 폴더로 들어가고
    #해당 카테고리에서 파일을 찾으면 visited에 추가시키면서 파일 갯수도 올리자

    for name, isFolder in category[folder]:
        #마지막 문자가 문자면 폴더
        if isFolder:
            child_set, child_cnt = sol(name)
            file_cnt += child_cnt
            file_set = file_set.union(child_set)
        else:
            file_set.add(name)
            file_cnt += 1
    info[folder] =  (len(file_set),file_cnt)
    return (file_set, file_cnt)





N, M = map(int,input().split())

category = defaultdict(list)
info = defaultdict(tuple)

for _ in range(N+M):
    P, F, C = input().split()
    category[P].append((F, int(C)))


Q = int(input())

for query in range(Q):
    visited = set()
    path = input().split("/")
    sol(path[-1])
    print(*info[path[-1]])

