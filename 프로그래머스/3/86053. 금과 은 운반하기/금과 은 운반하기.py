def solution(n_gold, n_silver, golds, silvers, weights, times):
    def deliver(time_limit):
        gold = silver = total = 0
        for i in range(len(golds)):
            # 편도 횟수
            one_way = time_limit // times[i]
            # 배달 횟수 = 왕복당 1회 + 1이 남으면 1 추가
            deliver_num = one_way // 2 + one_way % 2
            # 총 배송 가능 무게
            weight = deliver_num * weights[i]
            # 금만 보냈을 때 배송 가능한 금
            gold += min(golds[i], weight)
            # 은만 보냈을 때 배송 가능한 은
            silver += min(silvers[i], weight)
            # 배송 가능한 금과 은 모두!
            total += min(golds[i] + silvers[i], weight)
            # 금, 은, 모두가 배송 가능하면 True
        return gold >= n_gold and silver >= n_silver and total >= n_gold + n_silver

    end = answer = 10 ** 15
    start = 0
    while start <= end:
        mid = (start + end) // 2
        if deliver(mid):
            end = mid - 1
            answer = mid
        else:
            start = mid + 1
    return answer