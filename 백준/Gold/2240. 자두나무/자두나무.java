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
            for(int w=W;w>-1;w--){
                if((w+1)%2 == cur%2){
                    if(w==0){
                        dp[w] += 1;
                    }
                    else{
                        dp[w] = Math.max(dp[w], dp[w - 1])+1;
                    }
                }
                else{
                    if(w!=0){
                        dp[w] = Math.max(dp[w], dp[w - 1]);
                    }
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
