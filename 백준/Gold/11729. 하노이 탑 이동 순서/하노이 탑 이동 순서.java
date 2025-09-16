import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        System.out.println((1<<t)-1);
        StringBuilder sb = new StringBuilder();
        hanoi(t,1,3,sb);
        System.out.println(sb);
    }
    // disk 개 디스크를 a에서 b로 옮긴다.
    static void hanoi(int disk, int a, int b,StringBuilder sb){

        if(disk == 1){
            sb.append(a).append(" ").append(b);
            sb.append("\n");
        }
        else{
            hanoi(disk-1,a,6-a-b,sb);
            sb.append(a).append(" ").append(b);
            sb.append("\n");
            hanoi(disk-1,6-a-b,b,sb);
        }
    }
}
