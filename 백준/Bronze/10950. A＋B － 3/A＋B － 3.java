import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine()," ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append('\n');
        }
        System.out.println(sb);

    }
}