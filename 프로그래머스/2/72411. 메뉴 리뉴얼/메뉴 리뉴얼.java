import java.util.*;
class Solution {
    static Map<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        String[] order_list = new String[orders.length];
        List<String> ans_list = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            order_list[i] = String.valueOf(tmp);
        }
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            for(int j=0;j<order_list.length;j++){
                if(order_list[j].length()>=course[i]){
                    combi(order_list[j],new StringBuilder(),0,0,course[i]);
                }
            }
            int max = 0;
            for(String s:map.keySet()){
                max = Math.max(max,map.get(s));
            }
            for(String s:map.keySet()){
                if(max>=2 && map.get(s)==max){
                    ans_list.add(s);
                }
            }
            // System.out.println(map);
        }
        // System.out.println(Arrays.toString(order_list));
        Collections.sort(ans_list);
        // System.out.println(ans_list);
        String[] answer = new String[ans_list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans_list.get(i);
        }
        return answer;
    }
    public void combi(String order,StringBuilder sb, int idx, int cnt, int n){
        if(cnt == n){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        for(int i=idx;i<order.length();i++){
            sb.append(order.charAt(i));
            combi(order,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);
        }
    }
}