import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        //앞에서 부터 stack정복
        Stack<Pair> st = new Stack<>();
        int cnt = 0;
        long ans = 0;
        while(cnt < t){
            long now = Long.parseLong(br.readLine());
            //스택이 비어있으면
            if(st.isEmpty() || now < st.peek().key){
                st.add(new Pair(now,1));
            }
            else if(now == st.peek().key){
                ans += st.peek().num;
                st.peek().num += 1;
            }
            else{
                while(!st.isEmpty() && st.peek().key < now){
                    ans += st.pop().num;

                }
                if(!st.isEmpty() && st.peek().key == now){
                    ans += st.peek().num;
                    st.peek().num += 1;
                }
                else{
                    st.add(new Pair(now, 1));
                }
            }

            if(st.size() > 1){
                ans += 1;
            }

            cnt ++;
        }
        System.out.println(ans);
    }
    public static class Pair{
        long key;
        long num;
        public Pair(long key, long num){
            this.key = key;
            this.num = num;
        }
    }
}
