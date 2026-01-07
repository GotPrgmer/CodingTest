import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        //dp[i][j]는 i개, j개 문자열에서 LCS
        //i번째와 j번째가 같음
        // dp[i][j] = dp[i-1][j-1] + 1;

        //i번째는 LCS에 안들어감
        //j번째는 들어갈지 안들어갈 지 모름
        //그러면 dp[i-1][j]로 구하면 됨

        //j번째가 LCS에 안들어감
        //dp[i][j-1]

        int[][] dp = new int[1001][1001];
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                if(s1[i] == s2[j]) dp[i+1][j+1] = dp[i][j] + 1;
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        System.out.println(dp[s1.length][s2.length]);
    }
}
