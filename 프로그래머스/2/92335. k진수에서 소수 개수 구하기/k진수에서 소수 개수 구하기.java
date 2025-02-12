import java.util.*;
import java.util.stream.*;
class Solution {
    static boolean[] check;
    public int solution(int n, int k) {
        int answer = 0;
        String numToK = Integer.toString(n,k);
        String[] numsString = numToK.split("0");

        for(int i=0;i<numsString.length;i++){
            if(numsString[i].length() ==0){
                continue;
            }
            long num = Long.parseLong(numsString[i]);
            if(checkPrime(num) == true){
                answer += 1;
            }
        }
        return answer;
    }
    
    
        private boolean checkPrime(long num){
        
        if(num <=1){
            return false;
        }
        else{
            for(int i=2; i<=Math.sqrt(num);i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }
    
    
}