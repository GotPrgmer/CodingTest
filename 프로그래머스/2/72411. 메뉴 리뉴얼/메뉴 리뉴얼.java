import java.util.*;

class Solution {
    static Map<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        //문자열을 정렬
        String[] order = new String[orders.length];
        for(int i=0;i<orders.length;i++){
            char[] c_array = orders[i].toCharArray();
            Arrays.sort(c_array);
            order[i] = String.valueOf(c_array);
        }
        //course에 있는 조합의 길이에 해당되는 조합들을 각 사용자한테서 구하고
        //조합의 수중 가장 많은 수와 같이 매칭된 조합들을 추가하기
        List<String> ans = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            StringBuilder sb = new StringBuilder(); 
            for(int j=0;j<order.length;j++){
             if(order[j].length()>=course[i]){
                 combination(order[j],sb,0,0,course[i]);
             }   
            }
            // System.out.println(map);
            //조합 매칭된 사람수 중에 최대값 구하기
            int max = 0;
            for(String s:map.keySet()){
                max = Math.max(max,map.get(s));
            }
            // System.out.println(max);
            
            //매칭 최대값과 같은 조합을 정답에 추가하기
            for(String s:map.keySet()){
                if(max>=2 && max == map.get(s) && course[i] == s.length()){
                    ans.add(s);
                }
            }
        }
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    public void combination(String food_order,StringBuilder sb, int idx, int cnt, int n){
        if(cnt==n){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        else{
            for(int i=idx;i<food_order.length();i++){
                sb.append(food_order.charAt(i));
                combination(food_order,sb,i+1,cnt+1,n);
                sb.delete(cnt,cnt+1);
            }
        }
        
    }
    
}
