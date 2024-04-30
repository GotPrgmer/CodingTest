def solution(a, b, g, s, w, t):
    max_time = 4*(10**14)
    ans = max_time
    start = 0
    end = max_time
    while start <= end:
        #고른 시간
        mid = (start+end)//2
        #각 트럭이 고른 시간안에 이동해서 최대한으로 옮길수있는 광석 계산
        #얼마나 이동할 수 있는가?
        total_g = 0
        total_s = 0
        total_carry = 0
        
        for i in range(len(t)):
            #현재의 값들
            now_g = g[i]
            now_s = s[i]
            now_w = w[i]
            now_t = t[i]
            #현재 트럭은 얼마나 이동할 수 있는가?
            max_cnt = mid//(now_t*2)
            if mid%(now_t*2) >= now_t:
                max_cnt += 1
            total_g += min(now_g,max_cnt*now_w)
            total_s += min(now_s,max_cnt*now_w)
            total_carry += min(total_g+total_s,max_cnt*now_w)
        if total_g >= a and total_s >= b and total_carry >= a+b:
            #현재 시간으로 옮기기 가능!
            #시간을 더 줄여보자
            end = mid - 1
            ans = min(ans,mid)
        else:
            #시간을 더 늘려보자
            start= mid + 1
            
            
    return ans