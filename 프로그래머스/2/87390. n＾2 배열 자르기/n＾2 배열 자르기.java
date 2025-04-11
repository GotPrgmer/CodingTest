import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] nums = new int[(int)(right-left)+1];
        for(long i=left;i<right+1;i++){
            long cycle = i/n+1;
            long cnt = i%n+1;
            if(cnt > cycle){
                long value = cnt;
                nums[(int)(i-left)] = (int)value;
            }
            else{
                long value = cycle;
                nums[(int)(i-left)] = (int)value;
            }
            
        }

        return nums;
    }
}