import java.util.*;
class Solution {
    public int solution(int[] order) {
        //stack
        Stack<Integer> st = new Stack<>();
        int num = 1;
        int idx = 0;
        int cnt = 0;
        while(idx < order.length){
            //num을 하나씩 올리면서 매칭되면 cnt 올림.
            // System.out.println("num " + num +"idx " +idx +"cnt "+cnt);
            if(num < order[idx]){
                st.push(num);
                num +=1;
            }
            else if(num == order[idx]){
                idx += 1;
                cnt += 1;
                num += 1;
            }
            else{
                //stack을 보고 top이 같으면 cnt + 1아니면 break
                if(st.size() != 0 && st.peek() == order[idx]){
                    cnt += 1;
                    idx += 1;
                    st.pop();
                }
                else{
                    break;
                }
            }
        }
        return cnt;
    }
}