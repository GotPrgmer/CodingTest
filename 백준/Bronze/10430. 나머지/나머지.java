import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        sb.append((A + B) % C).append("\n");
        sb.append(((A%C) + (B%C))%C).append("\n");
        sb.append((A*B)%C).append("\n");
        sb.append(((A%C) * (B%C))%C);
        System.out.println(sb);
    }
}
