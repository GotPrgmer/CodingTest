import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        // 링크드 리스트로 K번째를 계속 순회하면서 모두 제거 될때까지 삭제
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int num=1;num<=N;num++){
            list.add(num);
        }
        int curK = K-1;
        while (true) {
            sb.append(list.get(curK));
            list.remove(curK);
            if ((curK + K) > list.size() && !list.isEmpty()) {
                curK = (curK + (K-1)) % list.size();
            }
            else if(!list.isEmpty()){
                curK += (K-1);
            }
            else{
                break;
            }
            sb.append(", ");

        }
        sb.append(">");
        System.out.println(sb);


    }
}
