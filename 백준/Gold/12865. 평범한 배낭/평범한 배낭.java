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
            int[][] dp = new int[N][100001];
            for(int i=0;i<K+1;i++){
                if(i>=weight[0]){
                    dp[0][i] = value[0];
                }
            }
            
            for(int i=1;i<N;i++){
                for(int j=1;j<K+1;j++){
                    // i를 선택하지 않을 때
                    dp[i][j] = dp[i-1][j];
                    // i를 선택했을때 최대값
                    // dp[i-1][j]가 0이 아닐때 추가할수있음
                    if(j-weight[i]>=0){
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-weight[i]]+value[i]);
                    }
                }
            }
            System.out.println(dp[N-1][K]);
        }
}