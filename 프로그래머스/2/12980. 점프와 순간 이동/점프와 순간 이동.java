import java.util.*;

public class Solution {
    public int solution(int n) {

        return bfs(n);
    }
    public int bfs(int n){
        int ans =0;
        while(n>=1){
            if(n%2==0){
                n /=2;
                continue;
            }
            n -= 1;
            ans +=1;
        }
        return ans;

    }
    public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.solution(1000));
}
}
