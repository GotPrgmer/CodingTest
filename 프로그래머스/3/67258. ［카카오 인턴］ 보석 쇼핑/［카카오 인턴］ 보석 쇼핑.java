import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int ans_left = 0;
        int ans_right = 0;
        int left = 0;
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int distance = Integer.MAX_VALUE;
        for(int i=0;i<gems.length;i++){
            set.add(gems[i]);
        }
        for(int right=0;right<gems.length;right++){
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            while(map.get(gems[left])>1){
                map.put(gems[left],map.get(gems[left])-1);
                left += 1;
            }
            if(map.size()==set.size() && distance>right-left){
                distance = right-left;
                ans_left = left+1;
                ans_right = right+1;
            }
        }
        return new int[]{ans_left, ans_right};
    }
}