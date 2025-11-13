import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int p:eratosChecker(M,N)) sb.append(p).append("\n");
        System.out.println(sb);
    }
    static List<Integer> eratosChecker(int M, int N){
        boolean[] isPrimes = new boolean[N + 1];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        for(int i=2;i*i<=N;i++){
            if(!isPrimes[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                isPrimes[j] = false;
            }
        }
        for (int i = M; i <= N; i++) {
            if(isPrimes[i]) ans.add(i);
        }
        return ans;

    }
}