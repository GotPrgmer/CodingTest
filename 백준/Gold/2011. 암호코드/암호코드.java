import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for(int i=2;i<s.length()+1;i++){
            char one = s.charAt(i - 1);
            char ten = s.charAt(i - 2);
            if (one != '0') {
                dp[i] = dp[i - 1] % MOD;
            }
            int num = (ten - '0') * 10 + (one - '0');
            if(num>=10 && num<=26){
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        System.out.println(dp[s.length()]);
    }
}
