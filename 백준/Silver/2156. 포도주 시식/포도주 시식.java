import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < n + 1; i++) {
            if (i <= 2) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]);
                if (i >= 5) {
                    dp[i] = Math.max(dp[i], dp[i - 4] + arr[i - 1] + arr[i]);
                }
            }
            
        }
        int ans = -1;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
