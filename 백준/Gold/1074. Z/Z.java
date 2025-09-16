import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(z(N,r,c));
    }
    static int z(int n, int r, int c) {
        if (n == 0){
            return 0;
        }
        else {
            int half = (1 << (n - 1));
            if (r >= 0 && r < 1 << (n - 1) && c >= 0 && c < 1 << (n - 1))
                return z(n - 1, r, c);
            else if (r >= 0 && r < 1 << (n - 1) && c >= 1 << (n - 1) && c < 1 << n)
                return half * half + z(n - 1, r, c - half);
            else if (r >= 1 << (n - 1) && r < 1 << n && c >= 0 && c < 1 << (n - 1))
                return 2 * half * half + z(n - 1, r - half, c);
            else
                return 3 * half * half + z(n - 1, r - half, c - half);
        }
    }

}