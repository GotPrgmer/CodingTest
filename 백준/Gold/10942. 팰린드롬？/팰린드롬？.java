import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][N+1];
        for(int i=1;i<N+1;i++) {
            dp[i][i]=true;
        }
        for(int i=1;i<N;i++){
            dp[i][i+1] = (arr[i] == arr[i+1])? true:false;
        }

        for(int len = 3; len <N+1;len++){
            for(int s = 1;s+len-1<N+1;s++){
                int e = s + len -1;
                if(arr[s] == arr[e] && dp[s+1][e-1]){
                    dp[s][e] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b]?1:0).append("\n");
        }

        System.out.println(sb);

    }
}
