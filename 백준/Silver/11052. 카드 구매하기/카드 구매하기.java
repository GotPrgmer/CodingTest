import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        int[] arr = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            dp[i] = arr[i];
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}