import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(comb(n, k));
    }
    private static int comb(int n, int k){
        return fact(n) / fact(n - k) / fact(k);
    }
    private static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n*fact(n-1);
    }

}
