import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1002][10];
        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<N+2;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                    dp[i][j] = (dp[i][j]+dp[i - 1][k])%10007;
                }
            }
        }
        System.out.println(dp[N+1][0]);
    }
}