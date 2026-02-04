import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charList = br.readLine().toCharArray();
        int[] ans = new int[26];
        for(int i=0;i<charList.length;i++){
            ans[charList[i]-97] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);


    }
}
