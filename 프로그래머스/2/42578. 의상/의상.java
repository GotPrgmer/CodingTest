import java.util.*;
class Solution {
    static Set<Set<String>> coms;
    static Set<String> tmp;
    static Map<String,Integer> kindCnt;
    public int solution(String[][] clothes) {
        kindCnt = new HashMap<>();
        coms = new HashSet<>();
        tmp = new HashSet<>();
        //종류 카운트 증가
        for(int i=0;i<clothes.length;i++){
            kindCnt.put(clothes[i][1],kindCnt.getOrDefault(clothes[i][1],0)+1);
        }
        int ans = 1;
        int kindsCnt = kindCnt.keySet().size();
        for(String s:kindCnt.keySet()){
            ans *= (kindCnt.get(s)+1);
        }
        return ans-1;
    }
}