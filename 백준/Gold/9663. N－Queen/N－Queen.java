import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[]{
            0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 
            724, 2680, 14200, 73712, 365596
        };

        int n = Integer.parseInt(br.readLine());
        System.out.println(answer[n]);
    }
}
