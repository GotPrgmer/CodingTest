import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(cal(A,B,C));

    }
    static long cal(int A, int B, int C){
        if(B==0){
            return 1;
        }
        else if(B==1){
            return A%C;
        }
        else{
            long val = cal(A,B/2,C)%C;
            val = val*val%C;
            if(B%2 == 0){
                return val;
            }
            else{
                return val*(A%C)%C;
            }
        }
    }
}