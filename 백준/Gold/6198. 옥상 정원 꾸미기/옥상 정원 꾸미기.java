import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        Stack<Long> st = new Stack<>();
        long ans = 0;
        for(int i=l-1;i>-1;i--){
            long h = Long.parseLong(br.readLine());
            //ans기록
            while(!st.isEmpty() && st.peek() <= h){
                st.pop();
            }
            ans += st.size();
            st.add(h);
        }
        System.out.println(ans);
    }
}
