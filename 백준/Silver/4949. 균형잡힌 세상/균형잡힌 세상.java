import java.io.*;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            boolean isMatch = true;
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            if(Objects.equals(input, ".")){
                break;
            }
            else{

                //괄호만 선택해서
                for(char c:input.toCharArray()){
                    // 열린 괄호
                    if(c =='(' || c==')' || c=='[' || c==']'){
                        if(c == '(' || c == '['){
                            stack.add(c);
                        }
                        // 닫힌 괄호
                        else{
                            //가장 최근 항목 조사
                            // 스택이 비어있으면 no
                            if(stack.isEmpty()){
                                isMatch = false;
                                break;
                            }
                            // 맞지 않으면 거기서 스톱하고 no 출력
                            else if(!check(c, stack.peek())){
                                isMatch = false;
                                break;
                            }
                            stack.pop();
                        }
                    }

                }
            }
            if(!stack.isEmpty() || !isMatch){
                System.out.println("no");
            }
            else{
                System.out.println("yes");
            }
        }
    }
    static boolean check(char c,char stackTop){
        char open = '.';
        if(c==']'){
            open = '[';
        }
        else if(c==')'){
            open = '(';
        }
        if(stackTop == open){
            return true;
        }
        else{
            return false;
        }
    }
}
