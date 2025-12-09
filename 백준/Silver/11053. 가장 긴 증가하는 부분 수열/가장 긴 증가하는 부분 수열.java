import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ans = 1;
        for(int i=1;i<N+1;i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);


    }
}
