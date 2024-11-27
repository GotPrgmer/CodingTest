
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        if(N==0){
            System.out.println(1);
        }
        else{
            while(N!=1){
                ans *= N;
                N -= 1;
            }
            System.out.println(ans);
        }

    }
}
