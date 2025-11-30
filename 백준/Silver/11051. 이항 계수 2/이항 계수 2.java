import java.util.*;
import java.io.*;
public class Main {
    static int[] factNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j=1;j<i;j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[N][K]);
    }

}
