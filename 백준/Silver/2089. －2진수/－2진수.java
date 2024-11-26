import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(change(Long.parseLong(input)));
    }
    static StringBuilder change(long x){
        StringBuilder sb = new StringBuilder();
        if(x==0){
            return sb.append("0");
        }
        while(x != 0){
                sb.append(Math.abs(x%(-2)));
                x = (int) (Math.ceil((double) x / -2));
            }
        return sb.reverse();
    }
}
