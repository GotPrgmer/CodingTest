import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for(int j=0;j<4;j++) {
                if(Integer.parseInt(st.nextToken()) == 0){
                    cnt += 1;
                }
            }
            if(cnt == 4){
                answer.add("D");
            }
            else if(cnt == 3){
                answer.add("C");
            }
            else if(cnt == 2){
                answer.add("B");
            }
            else if(cnt == 1){
                answer.add("A");
            }
            else{
                answer.add("E");
            }
        }
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }
}
