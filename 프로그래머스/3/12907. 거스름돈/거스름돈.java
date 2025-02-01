import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0;i<money.length;i++){
            for(int m=money[i];m<n+1;m++){
                dp[m] += dp[m-money[i]];
            }
        }
        return dp[n];
    }
}