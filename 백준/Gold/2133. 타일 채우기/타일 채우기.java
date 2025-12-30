import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for(int i=4;i<N+1;i++){
            if(i%2== 0 ) {
                //2를 붙이는 경우
                dp[i] = dp[i-2]*3;
                for (int j = i; j >= 2; j -= 2) {
                    if(j>2) dp[i] += dp[i - j]*2;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
