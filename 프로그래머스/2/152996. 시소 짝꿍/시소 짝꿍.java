import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Map<Double,Integer> map = new HashMap<>();
        Set<Double> set = new HashSet<>();
        Arrays.sort(weights);
        long ans = 0;
        for(int i=0;i<weights.length;i++){
            
            double original = weights[i] *1.0;
            double a = (weights[i] *2.0)/3.0;
            double b = (weights[i]*1.0) /2.0;
            double c = (weights[i] *3.0)/4.0;
            
            if(map.keySet().contains(a)){
                ans += map.get(a);
            }
            if(map.keySet().contains(b)){
                ans += map.get(b);
            }
            if(map.keySet().contains(c)){
                ans += map.get(c);
            }
            if(map.keySet().contains(original)){
                ans += map.get(original);
            }
            map.put(original,map.getOrDefault(original,0)+1);
        }
        // long ans = 0;
        // for(Double i:map.keySet()){
        //     ans += map.get(i)-1;
        // }
        System.out.println(map);
        return ans;
    }
    
    
}