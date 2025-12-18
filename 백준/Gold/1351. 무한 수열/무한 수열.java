import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static long[] dp;
    public static long P;
    public static long Q;
    public static Map<Long, Long> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L,1L);
        System.out.println(backtrack(N));
    }

    public static long backtrack(long N){
        if(N==0){
            return 1;
        }
        else if(map.containsKey(N)){
            return map.get(N);
        }
        // N/P와 N/Q가 필요함
        long a = backtrack(N/P);
        map.put(N/P,a);
        long b = backtrack(N/Q);
        map.put(N/Q,b);
        return backtrack(N/P) + backtrack(N/Q);
    }
}
