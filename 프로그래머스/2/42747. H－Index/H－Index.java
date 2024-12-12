import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int answer = citations.length;
        for(int idx=0;idx<citations.length;idx++){
            if(citations[idx]>=answer){
                return answer;
            }
            answer -= 1;
        }
        return answer;
    }
}