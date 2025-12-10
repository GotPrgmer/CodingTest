import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] val = new int[N+1];
        int[] dp = new int[N+1];
        int ans = -1;
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(j+arr[j]-1<i && i+arr[i]-1<=N){
                    dp[i] = Math.max(dp[j] + val[i], dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
}
