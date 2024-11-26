import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();
        int numLength = num.length();
        int way = Integer.parseInt(st.nextToken());
        br.close();
        // 2**0*1+2**1*0
        int ans = 0;
        int tmp = 1;
        for (int digit=0;digit<num.length();digit++){
            char curNum = num.charAt(numLength-1-digit);
            if((curNum>='A')){
                ans += (curNum - 'A' + 10) * tmp;
            }
            else{
                ans += (curNum-'0') * tmp;
            }
            tmp *= way;
        }
        System.out.println(ans);

    }
}