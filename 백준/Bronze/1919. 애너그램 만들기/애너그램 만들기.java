import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cnt = new int[26];
        String first = st.nextToken();
        for(char c:first.toCharArray()){
            cnt[(int)c - 97] += 1;
        }
        st = new StringTokenizer(br.readLine());
        String second = st.nextToken();
        for(char c:second.toCharArray()){
            cnt[(int)c - 97] -= 1;
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            if(cnt[i] > 0){
                ans += cnt[i];
            }
            else if(cnt[i] < 0){
                ans += -cnt[i];
            }
        }
        System.out.println(ans);
    }
}