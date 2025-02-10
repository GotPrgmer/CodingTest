import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        //map2채우기
        for(int i=0;i<topping.length;i++){
            map2.put(topping[i],map2.getOrDefault(topping[i],0)+1);
        }
        //돌면서 map1은 넣고 map2는 뺀다.
        int cnt =0;
        for(int i=0;i<topping.length;i++){
            map1.put(topping[i],map2.getOrDefault(topping[i],0)+1);
            //1개있으면 없애버림
            if(map2.getOrDefault(topping[i],0)==1){
                map2.remove(topping[i]);
            }
            else if(map2.getOrDefault(topping[i],0) != 0){
                map2.put(topping[i],map2.getOrDefault(topping[i],0)-1);
            }
            //사이즈 비교
            if(map1.keySet().size() == map2.keySet().size()){
                cnt += 1;
            }
            
        }
        System.out.println(cnt);
        int answer = -1;
        return cnt;
    }
}