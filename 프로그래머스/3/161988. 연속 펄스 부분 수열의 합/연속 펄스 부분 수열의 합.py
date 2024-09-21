def solution(sequence):
    #펄스 수열 서로 다른거 세팅해서
    #각각 수열을 구해서 가장 합이 큰 부분을 구하자
    first = [(-1)**i for i in range(len(sequence))]
    second = [(-1)**(i+1) for i in range(len(sequence))]
    for i in range(len(sequence)):
        first[i] = sequence[i]*first[i]
        second[i] = sequence[i]*second[i]
        
    dp1 = [first[0]]
    dp2 = [second[0]]
    for i in range(1,len(sequence)):
        dp1.append(max(first[i],first[i]+dp1[i-1]))
        dp2.append(max(second[i],second[i]+dp2[i-1]))
    
    return max(max(dp1),max(dp2))
