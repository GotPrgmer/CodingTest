def solution(n, times):
    s = 0
    e = 1000000000**2
    while s+1<e:
        m = (s+e)//2
        total = 0
        for t in times:
            total += m//t
        if total<n:
            s = m
        else:
            e = m
    print(e)
    return e