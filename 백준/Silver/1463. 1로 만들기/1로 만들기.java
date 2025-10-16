import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 3으로 나누어 떨어졌을 때 vs 2로 나누어 떨어졌을 때 비교
        // 만약 나누어 떨어지지 않는다면 1로 빼야지뭐
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<n+1;i++){
            int cnt = dp[i-1];
            if(i%3 == 0){
                cnt = Math.min(dp[i/3],cnt);
            }
            if(i%2 == 0){
                cnt = Math.min(dp[i/2],cnt);
            }
            dp[i] = cnt+1;
        }
        System.out.println(dp[n]);
    }
}
