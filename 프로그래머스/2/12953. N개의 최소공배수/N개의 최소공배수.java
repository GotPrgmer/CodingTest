import java.util.*;
class Solution {
    public long solution(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        nums.add(arr[0]);
        long cur = arr[0];
        long gcd = 1;
        for(int i=1;i<arr.length;i++){
            if(!nums.contains(arr[i])){
                gcd = gcd(cur,arr[i]);
                // System.out.println("gcd"+gcd);
                // System.out.println("oper"+cur+" "+arr[i]);
                cur = gcd * cur/gcd * arr[i]/gcd;
                // System.out.println("cur"+cur);
                nums.add(arr[i]);
            }
        }

        return cur;
    }
    public long gcd(long a, long b){
        long big = Math.max(a,b);
        long small = Math.min(a,b);
        while(true){
            long r = big%small;
            
            if(r==0){
                break;
            }
            else{
                big = small;
                small = r;
                continue;
            }
        }
        return small;
    }
}