import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverySum =0;
        int pickupSum = 0;
        for(int i=n-1;i>-1;i--){
            // 같은 i 거리를 여러번 왕복할수있으므로
            int cnt = 0;
            deliverySum += deliveries[i];
            pickupSum += pickups[i];
            
            while(deliverySum>0 || pickupSum >0){
                deliverySum -= cap;
                pickupSum -= cap;
                cnt += 1;
            }
            answer += (i+1)*2*cnt;
        }
        return answer;
        
    }
}