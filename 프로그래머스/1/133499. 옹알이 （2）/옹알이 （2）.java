import java.util.*;
class Solution {
    public static String[] wordsList;
    public static Set<String> visited;
    public int solution(String[] babbling) {
        wordsList = new String[]{"aya","ye","woo","ma"};
        int answer = 0;
        for(String str:babbling){
            visited = new HashSet<>();
            if(check(str,0,-1)){
                answer += 1;
            }
            else{
                continue;
            }
        }
        
        return answer;
    }
    public boolean check(String obj, int start,int findIdx){
        System.out.println(start);
        System.out.println(obj);
        System.out.println(findIdx);
        if(start == obj.length()){
            return true;
        }
        else{
            for(int i = 0; i<wordsList.length;i++){
                String word = wordsList[i];
                if(obj.indexOf(word,start) == start && i!=findIdx){
                    if(start == -1){
                        start = 0;
                    }
                    return check(obj,start+word.length(),i);
                }
            }
            return false;
        }
        
    }
}