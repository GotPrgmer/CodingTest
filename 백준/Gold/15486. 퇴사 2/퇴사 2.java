import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+2];
        int[] val = new int[N+2];
        int[] dp = new int[N+2];
        int ans = -1;
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N;i>=0;i--){
            if(i+arr[i]<=N){
                dp[i] = Math.max(val[i] + dp[i + arr[i]], dp[i+1]);
            }
            else{
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[0]);
        }
}
