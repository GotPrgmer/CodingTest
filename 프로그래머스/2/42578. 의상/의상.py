from collections import defaultdict
def solution(clothes):
    cntDict = defaultdict(int)
    for clothe in clothes:
        cntDict[clothe[1]] +=1
    ans = 1
    for kind in cntDict.keys():
        ans *= (cntDict[kind]+1)
    ans -= 1
    # print(cntDict)
    return ans