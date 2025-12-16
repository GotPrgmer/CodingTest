import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] dp = new long[k+1];
        dp[0] = 1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int c: arr){
            if(c>k) continue;
            for(int sum = c; sum<= k;sum++){
                dp[sum] += dp[sum-c];
            }
        }
        System.out.println(dp[k]);
    }
}
