import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int start = 0;
        int tmp = 0;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st_input = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<number.length();i++){
            tmp = Integer.parseInt(String.valueOf(number.charAt(i)));
            while(!st.isEmpty() && k>0 && tmp>st.peek()){
                st.pop();
                k--;
            }
            st.push(tmp);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        while(!st.isEmpty()){
            st_input.push(st.pop());
        }
        while(!st_input.isEmpty()){
            sb.append(st_input.pop());
        }
        return sb.toString();
    }
}