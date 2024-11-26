import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        isPrime = new boolean[N + 1];
        for(int checkIdx=0;checkIdx<Integer.parseInt(input[1])+1;checkIdx++){
            isPrime[checkIdx]=true;
        }
        isPrime[0]=false;
        isPrime[1]=false;
        for (int idx = 2; idx < Math.sqrt(N) + 1; idx++) {
            if(isPrime[idx]){
                for(int curIdx=idx*2;curIdx<N+1;curIdx += idx){
                    isPrime[curIdx]= false;
                }

            }
        }
        for(int numIdx=M;numIdx<N+1;numIdx++){
            if (isPrime[numIdx]) {
                sb.append(numIdx).append("\n");
            }
        }
        System.out.println(sb);
    }
}
