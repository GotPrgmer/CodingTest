import java.util.*;
class Solution {
    static int sum = 0;
    static int turnTotal = 0;
    public int[] solution(String s) {
        while(true){
            s = process(s);
            if(s.equals("1")){
                break;
            }
        }
        return new int[]{turnTotal,sum};
    }
    public String process(String str){
        int cnt = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                cnt += 1;
            }
        }
        sum += str.length()-cnt;
        turnTotal += 1;
        return Integer.toBinaryString(cnt);
    }
}