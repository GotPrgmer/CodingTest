import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        if(N==0){
            System.out.println(0);
            return;
        }
        int[] lose = new int[N+1];
        int[] happy = new int[N+1];
        int[][] dp = new int[N+1][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            lose[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++){
            for(int j=0;j<101;j++){
                if(j>lose[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - lose[i]] + happy[i]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][100]);

    }
}
