import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt10 = 0;
    static int cnt5 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int num = N; num > -1; num--) {
            divisor(num);
        }
        System.out.println(cnt10+Math.min(cnt5,cnt2));
    }

    static void divisor(int N) {
        while (N > 1) {
            if (N % 10 == 0) {
                N /= 10;
                cnt10 += 1;
            } else if (N % 5 == 0) {
                N /= 5;
                cnt5 += 1;
            } else if (N % 2 == 0) {
                N /= 2;
                cnt2 += 1;
            } else {
                break;
            }

        }
    }
}

