import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 0;
        for(int i=2;i<N+1;i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0){
                dp[i] = Math.min(dp[i / 2]+1, dp[i]);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i / 3]+1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    /*
    N에서 1혹은 2 혹은 3으로 줄여나가면서 최소를 선택해서 찍는다
     */
        int cur = N;
        StringBuilder sb = new StringBuilder();
        while(cur>0) {
            sb.append(cur).append(" ");
            int tmp = dp[cur-1];
            int val = cur-1;
            if(cur%2 == 0 && dp[cur/2] < tmp) {
                tmp = dp[cur/2];
                val = cur/2;
            }
            if(cur%3 == 0 && dp[cur/3] < tmp) {
                tmp = dp[cur/3];
                val = cur/3;
            }

            if(cur%3 == 0 && dp[cur-1] < tmp) {
                tmp = dp[cur-1];
                val = cur-1;
            }
            cur = val;
        }
        System.out.println(sb);

    }


}