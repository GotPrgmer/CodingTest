import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<t;i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                st.pop();
            }
            else{
                st.add(cmd);
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        System.out.println(ans);
    }
}