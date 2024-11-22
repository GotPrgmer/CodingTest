import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> prefix = new ArrayList<>();
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        prefix.add(input);
        for(int inputIdx=0;inputIdx<input.length()-1;inputIdx++){
            String curString = input.substring(inputIdx + 1);
            prefix.add(curString);

        }
        Collections.sort(prefix);
        for(int prefixIdx = 0 ;prefixIdx<prefix.size();prefixIdx++){
            sb.append(prefix.get(prefixIdx)).append("\n");
        }
        System.out.println(sb);
    }
}