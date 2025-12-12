import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] dp = new int[W+1];
        for(int t=0;t<T;t++){
            int cur = Integer.parseInt(br.readLine());
            for (int w = W; w >= 0; w--) {
                int pos = (w % 2 == 0) ? 1 : 2;
                int get = (pos == cur) ? 1 : 0;
                if (w == 0) {
                    dp[w] += get;
                } else {
                    dp[w] = Math.max(dp[w], dp[w - 1]) + get;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<W+1;i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
}