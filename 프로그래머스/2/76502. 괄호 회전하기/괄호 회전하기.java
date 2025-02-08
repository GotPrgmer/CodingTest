import java.util.*;
class Solution {
    static Set<Character> set;
    public int solution(String s) {
        set = new HashSet<>();
        set.add('{');
        set.add('(');
        set.add('[');
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int cnt = 0;
        for(int x=0;x<s.length();x++){
            if(x!=0){
                char tmp = s.charAt(x-1);
                sb.deleteCharAt(0);
                sb.append(tmp);
            }
            // System.out.println(sb.toString());
            if(check(sb.toString())){
                cnt += 1;
            }
        }
        return cnt;
    }
    private boolean check(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            
            if(set.contains(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else if(st.size()==0){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && st.peek() == '('){
                st.pop();
            }
            else if(s.charAt(i) == ']' && st.peek() == '['){
                st.pop();
            }
            else if(s.charAt(i) == '}' && st.peek() == '{'){
                st.pop();
            }
            else{
                return false;
            }
        }
        if(st.size()!=0){
            return false;
        }
        else{
            return true;
        }
        
        
    }
}
