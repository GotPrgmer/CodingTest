import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(gcd(A,B));
        System.out.println(lcm(A,B));


    }
    static int gcd(int x,int y){
        int bigger;
        int smaller;
        if(x>=y) {
            bigger = x;
            smaller = y;
        }
        else{
            bigger = y;
            smaller = x;
        }
        if(bigger%smaller ==0){
            return smaller;
        }
        else{
            return gcd(smaller, bigger % smaller);
        }
    }

    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}
