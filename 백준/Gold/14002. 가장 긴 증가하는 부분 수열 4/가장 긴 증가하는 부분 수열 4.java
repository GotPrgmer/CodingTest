import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        int[] prev = new int[N+1];
        for(int i=1;i<N+1;i++){
            dp[i] = 1;
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[i]<dp[j]+1){
                        prev[i] = j;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int num = 0;
        int root = -1;
        for(int i=1;i<N+1;i++){
            if(num<dp[i]){
                num = dp[i];
                root = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        int cur = root;
        while(cur>=1){
            stack.add(cur);
            cur = prev[cur];
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(arr[stack.pop()]).append(" ");
        }
        System.out.println(num);
        System.out.println(sb);
    }
}
