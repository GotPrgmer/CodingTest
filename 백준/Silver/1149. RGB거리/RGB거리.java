import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        StringTokenizer st;
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][3];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        dp[2][0] = Math.min(dp[1][1], dp[1][2])+arr[2][0];
        dp[2][1] = Math.min(dp[1][0], dp[1][2])+arr[2][1];
        dp[2][2] = Math.min(dp[1][0], dp[1][1])+arr[2][2];

        for(int i=3;i<n+1;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0])+arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
        }
        int ans = Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        System.out.println(ans);
    }
}