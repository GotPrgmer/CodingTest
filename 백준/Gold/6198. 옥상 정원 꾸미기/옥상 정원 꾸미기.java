import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static class Cooperator{
        int idx;
        long num;
        Cooperator(int idx, long num){
            this.idx = idx;
            this.num = num;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        for(int i=0;i<l;i++){
            list.add(Long.parseLong(br.readLine()));
        }
        Stack<Cooperator> st = new Stack<>();
        long ans = 0;
        for(int i=l-1;i>-1;i--){
            //ans기록
            if(!st.isEmpty()){
                while(!st.isEmpty() && st.peek().num<list.get(i)){
                    st.pop();
                }

            }
            if(!st.isEmpty()){
                ans += st.peek().idx-i-1;
            }
            else{
                ans += (l-1)-i;
            }
            st.add(new Cooperator(i,list.get(i)));
        }
        System.out.println(ans);
    }
}
