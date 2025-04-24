import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String[] s = Integer.toString(n,k).split("0");
        int cnt = 0;
        for(int i=0;i<s.length;i++){
            if(s[i].length()>0){
                if(isPrime(Long.parseLong(s[i]))){
                    cnt++;
                }
            }
        }
        System.out.println(isPrime(111));
        System.out.println(Arrays.toString(s));
        return cnt;
    }
    public boolean isPrime(long m){
        if(m==2){
            return true;
        }
        if(m==1){
            return false;
        }
        for(long i=2;i<Math.sqrt(m)+1;i++){
            if(m%i==0){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
}