import java.util.*;
class Solution {
    static Map<String,Integer> map;
    public int[] solution(String msg) {
        int[] answer = {};
        //map 초기화
        map = new HashMap<>();
        for(int i=1;i<27;i++){
            map.put("" + (char)(64+i),i);
        }
        //2~4
        String input = msg;
        List<Integer> ans = new ArrayList<>();
        while(input.length() != 0){
            int idx = binary(input);
            String findString = input.substring(0,idx);
            ans.add(map.get(findString));
            input = input.substring(idx);
            if(input.length() >=2){
                map.put(findString+input.charAt(0),map.size()+1);
            }
            
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
    private int binary(String msg){
        int l = 0;
        int h = msg.length()+1;
        while(l+1<h){
            int m = (l+h)/2;
            String check = msg.substring(0,m);
            if(map.containsKey(check)){
                l = m;
            }
            else{
                h = m;
            }
        }
        return l;
    }

    
}