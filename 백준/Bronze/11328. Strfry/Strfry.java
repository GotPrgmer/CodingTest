import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            //first문자열의 cnt
            int[] cnt = new int[26];
            for(char c:first.toCharArray()){
                cnt[(int)c-97] += 1;
            }

            for(char c:second.toCharArray()){
                cnt[(int)c-97] -= 1;
            }
            boolean flag = true;
            for(int j=0;j<26;j++){
                if(cnt[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }

        }

    }
}
