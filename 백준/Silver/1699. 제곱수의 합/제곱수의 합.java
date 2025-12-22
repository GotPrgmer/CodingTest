import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        for(int i=1;i<N+1;i++){
            dp[i] = i;
            for(int j=1;j*j<i+1;j++){
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }
        System.out.println(dp[N]);
    }
}
