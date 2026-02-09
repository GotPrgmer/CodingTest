import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(enigma(s1, s2));
    }
    private static int enigma(String s1, String s2){
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : s1.toCharArray()) {
            cnt1[c-'a'] += 1;
        }
        for (char c : s2.toCharArray()) {
            cnt2[c-'a'] += 1;
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            ans += Math.abs(cnt1[i] - cnt2[i]);
        }
        return ans;
    }
}
