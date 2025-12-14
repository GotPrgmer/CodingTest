import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<M;i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[N+1];
        for(int i=1;i<N+1;i++){
            if(i==1){
                dp[i] = 1;
            }
            else if(i==2){
                dp[2] = 2;
            }
            else{
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        int cnt = 0;
        int ans = 1;
        for(int i=1;i<N+1;i++){
            if (set.contains(i)&&cnt!=0) {
                ans = ans*dp[cnt];
                cnt = 0;
            }
            else if(!set.contains(i)){
                cnt++;
            }
        }
        if(cnt != 0){
            ans = ans*dp[cnt];
        }
        System.out.println(ans);
    }
}