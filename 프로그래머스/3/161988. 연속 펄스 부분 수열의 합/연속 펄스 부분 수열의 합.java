import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        for(int i=1;i<sequence.length;i++){
            dp[i][0] = Math.max(dp[i-1][1],0) + sequence[i];
            dp[i][1] = Math.max(dp[i-1][0],0) - sequence[i];
        }
        long ans = Long.MIN_VALUE;
        for(long[] c : dp){
            ans = Math.max(Math.max(c[0],c[1]),ans);
            // System.out.println(Arrays.toString(dp[i]));
        }
        
        return ans;
    }
}