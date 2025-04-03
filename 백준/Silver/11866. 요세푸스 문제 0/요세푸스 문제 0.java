import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
//        System.out.println(N+" "+ K);
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<N+1;i++){
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cnt%K == 0){
//                System.out.println(cnt+" "+cur);
                sb.append(cur);
                if(!q.isEmpty()){
                    sb.append(", ");
                }
            }
            else{
                q.add(cur);
            }
            cnt += 1;
        }
        sb.append(">");
        System.out.println(sb.toString());

    }

}