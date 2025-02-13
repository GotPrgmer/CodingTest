import java.util.*;
class Solution {
    static int[] nums;
    public int[] solution(int[] numbers) {
        nums = numbers;
        int[] ans = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>-1;i--){
            int bigNum = -1;
            while(st.size()!=0){
                //top이랑 확인해서 더크면 bigNum업데이트하고 브레이크
                //작으면 pop시키고 continue;
                if(st.peek() > nums[i]){
                    bigNum = st.peek();
                    break;
                }
                else{
                    st.pop();
                }
            }
            ans[i] = bigNum;
            st.push(nums[i]);
        }
        return ans;
    }
}