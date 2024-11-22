import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alCount = new int[26];
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int alphaI=0;alphaI<input.length();alphaI++){
            int tmp = input.charAt(alphaI) - 97;
            alCount[tmp] += 1;
        }
        for(int alCountIdx=0;alCountIdx<26;alCountIdx++){
            sb.append(alCount[alCountIdx]).append(" ");
        }
        System.out.println(sb);


    }
}