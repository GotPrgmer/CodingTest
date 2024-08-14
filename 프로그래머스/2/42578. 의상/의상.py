from itertools import combinations
from collections import defaultdict
def solution(clothes):
    #clothes를 돌면서 각 카테고리에 해당하는 것들을 리스트에 추가한다.
    category = defaultdict(list)
    for c in clothes:
        category[c[1]].append(c[0])
    clothes = [i for i in category.keys()]
    idxs = [i for i in range(len(clothes))]
    ans = 0
    tmp = 1
    for i in idxs:
        tmp *=len(category[clothes[idxs[i]]])+1
    ans =tmp -1

    return ans