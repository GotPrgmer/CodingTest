import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = -1001;
        int ans = -1000;
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(st.nextToken());
            sum = Math.max(cur, sum+cur);
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}
