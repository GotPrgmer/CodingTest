import java.util.*;
import java.io.*;
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] value = new int[N];
            int[] weight = new int[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[100001];
            for(int i=0;i<N;i++){
                //무게
                for(int j=K;j>-1;j--){
                    if(i==0 && j>=weight[0]){
                        dp[j] = value[0];
                    }
                    else if(j-weight[i]>=0){
                            dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
                    }
                }
            }
            System.out.println(dp[K]);
        }
}