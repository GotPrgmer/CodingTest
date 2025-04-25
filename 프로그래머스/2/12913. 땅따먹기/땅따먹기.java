import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for(int i=0;i<4;i++){
            dp[land.length-1][i] = land[land.length-1][i];
        }
        for(int i = land.length-1;i>0;i--){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(j!=k){
                        dp[i-1][j] = Math.max(dp[i-1][j],land[i-1][j]+dp[i][k]);
                    }
                }
            }
            
        }
        int ans = 0;
        for(int i=0;i<4;i++){
            ans = Math.max(ans,dp[0][i]);
        }
        // System.out.println(ans);


        return ans;
    }

    
}