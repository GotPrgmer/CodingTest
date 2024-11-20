import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < testCase) {
            st = new StringTokenizer(br.readLine(), ",");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append("\n");
            idx += 1;
        }
        System.out.println(sb);
    }
}
