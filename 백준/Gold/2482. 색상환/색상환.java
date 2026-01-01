import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if(K > N/ 2){
            System.out.println(0);
            return;
        }
        if(K == 1){
            System.out.println(N);
            return;
        }

        int[][] dp = new int[N + 1][K + 1];

        for(int i=0;i<=N;i++) dp[i][0] = 1;
        dp[1][1] = 1;

        for(int i= 2;i<=N;i++){
            dp[i][1] = i;
            int maxJ = Math.min(K, (i + 1) / 2);
            for (int j = 2; j <= maxJ; j++) {
                // i번째를 뽑지 않는 경우 + i번째를 뽑는 경우
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }
        long a = dp[N-3][K-1];
        long b = dp[N-1][K];
        long ans = (a + b) % MOD;
        System.out.println(ans);

    }
}
