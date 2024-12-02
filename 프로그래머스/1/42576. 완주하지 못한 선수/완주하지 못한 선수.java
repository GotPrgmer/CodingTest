import java.util.*;
import java.io.*;
class Solution {
    static Map<String,Integer> partMap;
    static Map<String,Integer> compMap;
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String[] participant, String[] completion) {
        partMap = new HashMap<>();
        compMap = new HashMap<>();
        for(String done:completion){
            compMap.put(done,compMap.getOrDefault(done,0)+1);
        }
        for(String sportMan:participant){
            partMap.put(sportMan,partMap.getOrDefault(sportMan,0)+1);
        }
        for(String man:partMap.keySet()){
            if(compMap.getOrDefault(man,0)<partMap.get(man)){
                sb.append(man);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s);
    }
}