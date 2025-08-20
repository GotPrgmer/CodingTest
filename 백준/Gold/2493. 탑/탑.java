import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        Stack<Cooperator> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        StringTokenizer stringToken = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++){
            int n = Integer.parseInt(stringToken.nextToken());
            list.add(n);
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(st.isEmpty()){
                ans.add(0);
            }
            else{
                while(!st.isEmpty() && st.peek().num < list.get(i)){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans.add(0);
                }
                else{
                    ans.add(st.peek().idx+1);
                }
            }
            st.add(new Cooperator(i,list.get(i)));
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static class Cooperator{
        int idx;
        int num;
        public Cooperator(int idx, int num){
            this.idx=idx;
            this.num = num;
        }
    }
}
