from itertools import combinations
def solution(k, tangerine):
    comb = combinations(tangerine,k)
    ans = k
    for c in comb:
        ans = min(ans,len(set(c)))
    return ans