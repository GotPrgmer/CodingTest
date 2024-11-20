import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
        try{
                st = new StringTokenizer(br.readLine(), " ");
                sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
                sb.append("\n");
            }
        catch (Exception e){
            break;
        }
        }
        System.out.println(sb);

    }
}