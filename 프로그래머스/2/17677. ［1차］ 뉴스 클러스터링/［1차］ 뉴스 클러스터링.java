import java.util.*;
class Solution {
    static Map<String, Integer> mapA;
    static Map<String, Integer> mapB;
    public int solution(String str1, String str2) {
        mapA = new HashMap<>();
        mapB = new HashMap<>();
        for(int i=1;i<str1.length();i++){
            if(Character.isAlphabetic(str1.charAt(i-1)) && Character.isAlphabetic(str1.charAt(i))){
                String cur = str1.substring(i-1,i+1);
                System.out.println(cur.toUpperCase());
                System.out.println(mapA.getOrDefault(cur,0));
                mapA.put(cur.toUpperCase(),mapA.getOrDefault(cur.toUpperCase(),0)+1);
            }
            
        }
        System.out.println("!11111111");
        
        for(int i=1;i<str2.length();i++){
            if(Character.isAlphabetic(str2.charAt(i-1)) && Character.isAlphabetic(str2.charAt(i))){
                String cur = str2.substring(i-1,i+1);
                System.out.println(cur.toUpperCase());
                mapB.put(cur.toUpperCase(),mapB.getOrDefault(cur.toUpperCase(),0)+1);
            }
        }
        if(mapA.keySet().size() == 0 && mapB.keySet().size() == 0){
            return 65536;
        }
        System.out.println(mapA);
        System.out.println(mapB);
        int intersection = 0;
        for(String s : mapA.keySet()){
            intersection += Math.min(mapA.getOrDefault(s,0),mapB.getOrDefault(s,0));
        }
        int union = 0;
        for(String s : mapA.keySet()){
            if(!mapB.containsKey(s)){
                union += mapA.getOrDefault(s,0);
            }
        }
        for(String s : mapB.keySet()){
            if(!mapA.containsKey(s)){
                union += mapB.getOrDefault(s,0);
            }
        }
        for(String s : mapA.keySet()){
            if(mapB.containsKey(s)){
                union += Math.max(mapA.getOrDefault(s,0),mapB.getOrDefault(s,0));
            }
        }

        int answer = 0;
        System.out.println("" + intersection +" " +union);
        return 65536*intersection/union;
    }
}