import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        for(int i=0;i<t;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<t+1;i++){
            sb.append("+");
            st.add(i);
            while(!st.isEmpty()){
                if(Objects.equals(st.peek(), list.get(pos))){
                    sb.append("-");
                    st.pop();
                    pos += 1;
                }
                else{
                    break;
                }
            }

        }
        if(!st.isEmpty()){
            System.out.println("NO");
        }
        else{
            String ansString = sb.toString();
            for(int i = 0; i< ansString.length(); i++){
                System.out.println(ansString.charAt(i));
            }
        }
    }



}
