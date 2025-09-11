import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<t;i++){
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c:input.toCharArray()){
                if(!stack.isEmpty()){
                    if(stack.peek() == c){
                        stack.pop();
                    }
                    else{
                        stack.add(c);
                    }
                }
                else{
                    stack.add(c);
                }
            }
            if(stack.isEmpty()){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}