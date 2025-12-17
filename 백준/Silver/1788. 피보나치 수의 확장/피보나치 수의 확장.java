import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(n == 0){
            sb.append(0).append("\n");
            sb.append(0);
            System.out.println(sb);
        }
        else{
            boolean isMinus = false;
            if (n < 0) {
                n = -1*n;
                //홀수
                if(n % 2 == 0){
                    isMinus = true;
                }
            }
            long[] dp = new long[1_000_001];
            dp[1] = 1;
            for(int i=2;i<n+1;i++){
                dp[i] = (dp[i-1] + dp[i-2])%1_000_000_000;
            }
            if(isMinus){
                sb.append(-1).append("\n");
                sb.append(dp[n]);
            }
            else{
                sb.append(1).append("\n");
                sb.append(dp[n]);
            }
            System.out.println(sb);

        }

    }
}
