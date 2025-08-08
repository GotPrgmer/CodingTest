import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<T;i++){
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            if(cmd.equals("push")){
                st.add(Integer.parseInt(input[1]));
            }
            else if(cmd.equals("pop")){
                if(!st.isEmpty()){
                    System.out.println(st.pop());
                }
                else{
                    System.out.println(-1);
                }

            }
            else if(cmd.equals("size")){
                System.out.println(st.size());
            }
            else if(cmd.equals("empty")){
                if(st.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(cmd.equals("top")){
                if(!st.isEmpty()){
                    System.out.println(st.peek());
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }
}
