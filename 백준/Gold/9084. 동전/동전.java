import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coins = new int[21];
            int[][] dp = new int[10001][21];
            Arrays.fill(dp[0], 1);
            for(int i=1;i<N+1;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int goal = Integer.parseInt(br.readLine());
            for(int c=1;c<N+1;c++){
                for(int i=1;i<goal+1;i++){
                    dp[i][c] = dp[i][c-1];
                    if(i-coins[c]>=0) dp[i][c] += dp[i-coins[c]][c];
                }
            }
            System.out.println(dp[goal][N]);
        }
    }
}
