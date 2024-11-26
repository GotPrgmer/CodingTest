import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        StringBuilder sb = new StringBuilder();

        for(int startIdx=N.length()-1;startIdx>-1;startIdx -= 3){
            int culNum = 0;
            int tmp = 1;
            for(int curIdx=startIdx;curIdx>Math.max(startIdx-3,-1);curIdx--){
                culNum += (N.charAt(curIdx)-'0')*tmp;
                tmp *= 2;
            }
            sb.insert(0,culNum);
        }
        System.out.println(sb);
    }
}
