import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        String addAB = st[0] + st[1];
        String addCD = st[2] + st[3];
        System.out.println(Long.parseLong(addAB) + Long.parseLong(addCD));
    }
}
