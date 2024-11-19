import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int first = Integer.parseInt(st[0]);
        int second = Integer.parseInt(st[1]);
        System.out.println(first + second);
    }
}
