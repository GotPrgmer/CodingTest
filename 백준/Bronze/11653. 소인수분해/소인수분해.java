import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for(int cnt=2;cnt<Math.sqrt(N)+1;cnt++){
            if(arr[cnt]){
                for(int check=cnt*2;check<N+1;check += cnt){
                    arr[check] = false;
                }
            }
        }
        while(N!=1){
            for(int prime=2;prime<N+1;prime++){
                if(arr[prime] && N%prime==0){
                    sb.append(prime).append("\n");
                    N/=prime;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}