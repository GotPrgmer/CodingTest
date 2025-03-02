class Solution {
    public int solution(int n) {
        int l = 1;
        int r = 1;
        int cur = 1;
        int ans = 0;
        while(l<=r&&l<=n){
            // System.out.println(cur);
            if(cur==n){
                ans += 1;
                r += 1;
                cur += r;
            }
            else if(cur>n){
                cur -= l;
                l += 1;
            }
            else{
                r += 1;
                cur += r;
            }
        }
        return ans;
    }
}