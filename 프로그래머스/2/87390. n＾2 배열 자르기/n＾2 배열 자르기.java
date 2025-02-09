class Solution {
    public int[] solution(int n, long left, long right) {
        long cur_r = left/n;
        long cur_c = left%n;
        long goal_r = right/n;
        long goal_c = right%n;
        int[] answer = new int[(int)(right-left+1)];
        int cnt = 0;
        while(cnt != right-left+1){
            answer[cnt] = (int)(Math.max(cur_r,cur_c)+1);
            cnt += 1;
            if(cur_c==n-1){
                cur_r += 1;
                cur_c = 0;
            }
            else{
                cur_c += 1;
            }
            
        }
        return answer;
    }
}