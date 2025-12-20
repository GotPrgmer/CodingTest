import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[1000][1000];
        for(int i=0;i<n;i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                board[i][j] = input[j]-'0';
            }
//            System.out.println(Arrays.toString(board[i]));
        }
        int[][] dp = new int[1000][1000];
        int ans = 0;
        for(int i=n-1;i>-1;i--){
            for(int j=m-1;j>-1;j--){
                if(j==m-1 || i==n-1) dp[i][j] = board[i][j];
                else{
                    if(board[i][j] != 0) dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]))+1;

                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
//        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(dp[i]));

        System.out.println(ans*ans);
    }
}
