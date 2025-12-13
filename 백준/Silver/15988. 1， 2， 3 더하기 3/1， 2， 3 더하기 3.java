import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final long DIVISOR = 1_000_000_009;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<1000001;i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %=DIVISOR;
        }
        int[] test = new int[T];
        for(int t=0;t<T;t++){
            test[t] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            sb.append(dp[test[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
