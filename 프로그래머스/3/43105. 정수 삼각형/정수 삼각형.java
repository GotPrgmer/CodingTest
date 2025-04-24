class Solution {
    public int solution(int[][] triangle) {
        for(int h=triangle.length-1;h>0;h--){
            for(int i=0;i<triangle[h].length-1;i++){
                triangle[h-1][i] += Math.max(triangle[h][i],triangle[h][i+1]);
            }
        }
        int answer = 0;
        return triangle[0][0];
    }
}