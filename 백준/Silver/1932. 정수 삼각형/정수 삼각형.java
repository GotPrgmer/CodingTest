import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            //입력
            for(int j=0;j<i+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];

        for(int i=0;i<n-1;i++){
            for(int j=0;j<i+1;j++){
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if (ans < dp[n - 1][i]) {
                ans = dp[n - 1][i];
            }
        }
        System.out.println(ans);
    }
}
