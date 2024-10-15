def solution(n):
    bin_exp = bin(n)
    one_cnt = 0
    for s in bin_exp[2:]:
        if s == '1':
            one_cnt += 1
    compare = n+1
    while True:
        bin_exp = bin(compare)
        tmp = 0
        for s in bin_exp[2:]:
            if s == '1':
                tmp += 1
        if tmp == one_cnt:
            return compare
        compare += 1
