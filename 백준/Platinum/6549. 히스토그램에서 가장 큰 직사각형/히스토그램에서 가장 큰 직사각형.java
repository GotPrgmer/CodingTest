import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Pair{
        long length;
        int idx;
        public Pair(long length, int idx){
            this.length = length;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            long ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if(t != 0){
                Stack<Pair> stack = new Stack<>();
                for(int i=0;i<t;i++){
                    long length = Long.parseLong(st.nextToken());
                    while(!stack.isEmpty() && stack.peek().length >= length){
                        //빼면서 현재값*(현재 idx - top idx)
                        Pair p = stack.pop();
                        int topIdx = 0;
                        if(!stack.isEmpty()){
                            topIdx = stack.peek().idx;
                            ans = Math.max(ans, p.length*(i-1-topIdx));
                        }
                        else{
                            ans = Math.max(ans, p.length*(i));
                        }
//                        System.out.println(p.length*(i-1-topIdx));

                    }
                    stack.add(new Pair(length,i));

                }
                //stack순회
                while(!stack.isEmpty()){
                    Pair p = stack.pop();
                    int topIdx = 0;
                    if(!stack.isEmpty()){
                        topIdx = stack.peek().idx;
                        ans = Math.max(ans, p.length*(t-(topIdx+1)));
                    }
                    else{
                        ans = Math.max(ans, p.length*(t));
                    }
                }

            }
            else{
                break;
            }
            System.out.println(ans);
        }

    }
}