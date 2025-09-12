import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Pair> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '('){
                stack.add(new Pair(i,'('));
            }
            else{
                //stack top에 좌표 비고해서 1차이나면 레이저 처리하고
                if(stack.peek().idx+1==i){
                    stack.pop();
                    ans += stack.size();

                }
                //아니면 1을 증가한다.
                else{
                    stack.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
class Pair{
    int idx;
    char c;
    Pair(int idx, char c){
        this.idx = idx;
        this.c = c;
    }
}