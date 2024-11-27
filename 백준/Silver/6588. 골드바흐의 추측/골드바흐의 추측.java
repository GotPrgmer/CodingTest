import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] prime;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime = new boolean[100_0001];
        Arrays.fill(prime, true);
        prime[0] =false;
        prime[1] = true;
        for(int idx=2;idx<Math.sqrt(prime.length+1)+1;idx++){
            if(prime[idx]){
                for(int curIdx=idx*2;curIdx<prime.length;curIdx += idx){
                    prime[curIdx] = false;
                }
            }
        }
        while(true){
            int curTest = Integer.parseInt(br.readLine());
            boolean flag;
            if (curTest != 0) {
                flag = false;
                for(int idx=3;idx<curTest/2+1;idx++){
                    if (prime[idx] && idx % 2 == 1 && prime[curTest - idx] && (curTest-idx)%2==1) {
                        sb.append(curTest).append(" = ").append(idx).append(" + ").append(curTest - idx).append("\n");
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    sb.append("Goldbach's conjecture is wrong.").append("\n");
                }
            }
            else{
                break;
            }
        }
        System.out.println(sb);

    }
}
