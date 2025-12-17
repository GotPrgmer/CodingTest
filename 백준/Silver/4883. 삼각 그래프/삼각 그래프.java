import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final static long MAX = 1_000_000_000_000L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while(true){

            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                return;
            }
            int[][] arr = new int[N + 1][3 + 1];
            long[][] dp = new long[N + 1][3 + 1];
            StringTokenizer st;
            for(int i=1;i<N+1;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<3+1;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1;i<N+1;i++){
                Arrays.fill(dp[i], MAX);
            }
            dp[1][1] = MAX;
            dp[1][2] = arr[1][2];
            dp[1][3] = arr[1][2] + arr[1][3];

            //비용 계산
            for(int i=2;i<N+1;i++){
                dp[i][1] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][1];

                dp[i][2] = Math.min(
                        dp[i][1],
                        Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3]))
                ) + arr[i][2];

                dp[i][3] = Math.min(
                        dp[i][2],
                        Math.min(dp[i-1][2], dp[i-1][3])
                ) + arr[i][3];
            }

            StringBuilder sb = new StringBuilder();
            sb.append(testCase++).append(". ").append(dp[N][2]);
            System.out.println(sb);
        }


    }
}
