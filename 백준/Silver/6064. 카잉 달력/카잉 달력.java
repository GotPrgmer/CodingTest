import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(solve(M, N, x, y)).append("\n");
        }
        System.out.println(sb);
    }
    private static int solve(int M, int N, int x, int y){
        //LCM구하기
        int gcd  = gcd(M, N);
//        System.out.println(gcd);
        int lcm = M/gcd*N;
        if(x== M) x = 0;
        if(y==N) y = 0;
        List<Integer> yList = new ArrayList<>();
        for(int i=x;i<=lcm;i+=M){
            if(i!=0){
                yList.add(i);
            }
        }

        for(int i=0;i<yList.size();i++){
            if (yList.get(i) % N == y) {
                return yList.get(i);
            }
        }
        return -1;
    }
    private static int gcd(int M, int N){
        if(N == 0){
            return M;
        }
        else{
            return gcd(N, M % N);
        }
    }
}
