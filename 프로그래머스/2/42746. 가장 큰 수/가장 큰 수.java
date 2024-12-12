import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] numToStr = new String[numbers.length];
        for(int idx=0;idx<numbers.length;idx++){
            numToStr[idx] = String.valueOf(numbers[idx]);
        }
        Arrays.sort(numToStr,(s1,s2)->(s2+s1).compareTo(s1+s2));
        if(numToStr[0].equals("0")){
            return "0";
        }
        String answer = String.join("",numToStr);

        return answer;
    }
}