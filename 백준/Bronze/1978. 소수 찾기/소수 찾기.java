import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int t = 0; t < N; t++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) continue;
            ans += isPrime(num);
        }
        System.out.println(ans);
    }
    static int isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}