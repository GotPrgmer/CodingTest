
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=0;test<t;test++){
            long answer = 0;
            String[] input = br.readLine().split(" ");
            for(int numIdx=1;numIdx<input.length-1;numIdx++){
                for(int compareIdx=numIdx+1;compareIdx<input.length;compareIdx++){
                    long A = Long.parseLong(input[numIdx]);
                    long B = Long.parseLong(input[compareIdx]);
                    long tmp = gcd(A, B);
                    answer += tmp;
                }
            }

            System.out.println(answer);
        }
    }
    static long gcd(long x, long y){
        if (y == 0) {
            return x;
        }
        else{
            return gcd(y, x % y);
        }
    }
}
