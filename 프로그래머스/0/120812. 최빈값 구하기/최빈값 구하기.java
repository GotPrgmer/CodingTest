import java.util.*;
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public int solution(int[] array) {
        for(int i=0;i<array.length;i++){
            if(map.getOrDefault(array[i],-1) != -1){
                System.out.println(map.get(array[i]));
                map.put(array[i],map.get(array[i])+1);
            }
            else{
                map.put(array[i],0);
            }
        }
        System.out.println(map);
//         List<Integer> ans = new ArrayList<>();
//         for(Integer key:map.keySet()){
//             if(ans<key){
                
//             }
//         }
        int answer = 0;
        return answer;
    }
}