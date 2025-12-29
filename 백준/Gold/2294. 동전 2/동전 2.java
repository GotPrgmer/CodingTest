import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final int INF = 1_000_000_000;
        int[][] dp = new int[10001][101];
        for (int k = 0; k <= m; k++) {
            Arrays.fill(dp[k], INF);
        }

        for (int i = 0; i <= n; i++) dp[0][i] = 0;
        int[] coin = new int[101];

        for(int i=1;i<n+1;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<n+1;i++){
            for(int k=1;k<m+1;k++){
                dp[k][i] = dp[k][i-1];
                if (k >= coin[i] && dp[k - coin[i]][i] != INF) {
                    dp[k][i] = Math.min(dp[k][i], dp[k - coin[i]][i] + 1);
                }
            }
        }
        if (dp[m][n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m][n]);
        }
    }
}