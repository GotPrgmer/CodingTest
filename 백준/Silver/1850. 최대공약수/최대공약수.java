import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long aLength = Long.parseLong(input[0]);
        long bLength = Long.parseLong(input[1]);
        System.out.println("1".repeat((int)gcd(aLength,bLength)));
    }

    static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        else{
            return gcd(y, x % y);
        }
    }
}