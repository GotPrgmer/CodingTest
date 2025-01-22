class Solution {
    public int[][] solution(int n) {
        int[] d_r = {0,1,0,-1};
        int[] d_c = {1,0,-1,0};
        int[][] answer = new int[n][n];
        int cur_r = 0;
        int cur_c = 0;
        int d = 0;
        
        for(int i=1;i<n*n+1;i++){
            System.out.println(i + " " + cur_r + " " +cur_c);
            answer[cur_r][cur_c] = i;
            int next_r = cur_r+d_r[d];
            int next_c = cur_c+d_c[d];
            if(check(next_r,next_c,n)){
                if(answer[next_r][next_c] == 0){
                    cur_r = next_r;
                    cur_c = next_c;
                    continue;
                }
                else{
                    d = (d+1)%4;
                    cur_r = cur_r+d_r[d];
                    cur_c = cur_c+d_c[d];
                }
            }
            else{
                d = (d+1)%4;
                cur_r = cur_r+d_r[d];
                cur_c = cur_c+d_c[d];
            }
            System.out.println(i + " " + next_r + " " +next_c);

        }
        return answer;
    }
    public boolean check(int r, int c,int n){
        if(0<=r && r<n && 0<=c && c<n){
            return true;
        }
        else{
            return false;
        }
    }
}