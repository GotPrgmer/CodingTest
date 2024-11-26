
import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<String> st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        st = digitChange(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        while(!st.isEmpty()){
            bw.write(st.pop());
        }
        bw.close();
        System.out.println(bw);
    }

    static Stack<String> digitChange(int num, int way) throws IOException {
        st = new Stack<>();

        while(num != 0){
            int curRemain = num % way;
            if(curRemain>=10){
                st.add(Character.toString(curRemain+55));
            }
            else{
                st.add(String.valueOf(curRemain));
            }
            num /= way;
        }
        return st;
    }
}
