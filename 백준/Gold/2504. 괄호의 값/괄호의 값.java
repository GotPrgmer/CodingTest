import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Coop> stack = new Stack<>();
        int tmp = 1;
        int ans = 0;
        boolean isError = false;
        int lenChar = input.length;
        int cnt = 0;
        while(cnt < lenChar){
            char c = input[cnt];
            if(c == '('){
                stack.add(new Coop(cnt,c));
                tmp *= 2;
            }
            else if(c == ')'){
                if(!stack.isEmpty() && stack.peek().value=='('){
                    if(stack.peek().idx == cnt-1){
                        ans += tmp;
                    }
                    tmp /= 2;
                    stack.pop();
                }
                else{
                    isError = true;
                    break;
                }
            }
            else if(c == '['){
                stack.add(new Coop(cnt,c));
                tmp *= 3;
            }
            else if(c == ']'){
                if(!stack.isEmpty() && stack.peek().value=='['){
                    if(stack.peek().idx == cnt-1){
                        ans += tmp;
                    }
                    tmp /= 3;
                    stack.pop();
                }
                else{
                    isError = true;
                    break;
                }
            }
            cnt += 1;
        }
        if(isError || !stack.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(ans);
        }
    }
}
class Coop{
    int idx;
    char value;
    Coop(int idx, char value){
        this.idx = idx;
        this.value = value;
    }
}
