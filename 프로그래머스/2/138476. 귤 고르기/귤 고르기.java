import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        List<int[]> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        for(Integer i:map.keySet()){
            list.add(new int[]{map.get(i),i});
        }
        Collections.sort(list,(x,y)->y[0]-x[0]);
        int cnt = 0;
        int answer = 0;
        for(int[] i:list){
            cnt += i[0];
            answer += 1;
            if(cnt>=k){
                break;
            }
        }
        
        return answer;
    }
}