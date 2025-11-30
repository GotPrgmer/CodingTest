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
        factNum = new int[N+1];
        for(int i=1;i<N+1;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for(int i=2;i<N+1;i++){
            for(int j=1;j<i;j++){
                if(dp[i-1][j-1] == 0){
                    dp[i - 1][j - 1] = fact(i - 1) / fact(i - j) / fact(j - 1);
                }
                if(dp[i-1][j] == 0){
                    dp[i - 1][j] = fact(i - 1) / fact(i - j -1) / fact(j);
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[N][K]);
    }
    private static int fact(int N){
        if(N==0){
            return 1;
        }
        else{
            if(factNum[N]!=0){
                return factNum[N];
            }
            else{
                factNum[N] = (N*fact(N-1)%10007)%10007;
                return factNum[N];            }
        }

    }
}
