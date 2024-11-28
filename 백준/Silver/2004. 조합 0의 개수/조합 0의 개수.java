import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int twoCnt = check(N, 2) - check(M,2)-check(N-M,2);
        int fiveCnt = check(N, 5) - check(M, 5) - check(N - M, 5);
        System.out.println(Math.min(twoCnt, fiveCnt));
    }
    private static int check(int N, int k) {
        int cnt = 0;
        while (N >= k) {
            cnt += N / k;
            N /= k;
        }
        return cnt;
    }
}