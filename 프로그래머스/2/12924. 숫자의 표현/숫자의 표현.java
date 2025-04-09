import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] nums = new int[n+1];
        for(int i=1;i<n+1;i++){
            nums[i] = i;
        }
        //누적합
        for(int i=2;i<n+1;i++){
            nums[i] += nums[i-1];
        }
        int s = 0;
        int e = 1;
        int ans = 0;
        while(s<e && e<n+1){
            int cur = nums[e]-nums[s];
            //n보다 작으면 e 올리고
            if(cur<=n){
                e += 1;
                if(cur == n){
                    ans += 1;
                }
            }
            //n보다 크면 s 올리고
            else{
                s += 1;
            }
        }
        return ans;
    }
}