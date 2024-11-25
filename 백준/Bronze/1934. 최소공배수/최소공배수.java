import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int testLine=0;testLine<T;testLine++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(lcm(A,B));
        }
    }
    static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        else{
            return gcd(y, x % y);
        }
    }
    static int lcm(int x, int y){
        return (x * y) / gcd(x, y);
    }
}
