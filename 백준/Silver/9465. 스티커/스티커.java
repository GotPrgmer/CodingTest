import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100_001][3];
            int[][] dp = new int[100_001][3];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<n+1;i++){
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<n+1;i++){
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            //dp
            dp[1][1] = arr[1][1];
            dp[1][2] = arr[1][2];
            for(int i=2;i<n+1;i++){
                dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1])+arr[i][2];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2])+arr[i][1];
                dp[i][0] = dp[i-1][0];
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));

        }
    }
}
