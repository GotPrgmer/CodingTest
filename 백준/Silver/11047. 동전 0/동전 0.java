import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int i=0;i<N;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int rem = K;
        int ans = 0;
        for(int i=N-1;i>-1;i--){
            if(rem/coins[i]>0){
                ans += rem/coins[i];
                rem = rem%coins[i];
            }
        }
        System.out.println(ans);
    }
}
