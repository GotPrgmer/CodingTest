from collections import defaultdict
def solution(k, tangerine):
    t_cnt = defaultdict(int)
    for t in tangerine:
        t_cnt[t] += 1
    tangerine_set = set(tangerine)
    t_sort = []
    for t in tangerine_set:
        t_sort.append([t_cnt[t],t])
    t_sort.sort(reverse=True)
    ans = 0
    cnt = 0
    for t in t_sort:
        cnt += t[0]
        ans += 1
        if cnt >=k:
            return ans
