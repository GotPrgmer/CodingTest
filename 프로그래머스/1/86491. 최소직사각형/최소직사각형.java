class Solution {
    public int solution(int[][] sizes) {
        int horizon = 0;
        int vertical = 0;
        int big = 0;
        int small = 0;
        for(int row=0;row<sizes.length;row++){
            big = Math.max(sizes[row][0],sizes[row][1]);
            small = Math.min(sizes[row][0],sizes[row][1]);
            horizon = Math.max(big,horizon);
            vertical = Math.max(small,vertical);
        }
        System.out.println(horizon);
        System.out.println(vertical);

        return horizon*vertical;
    }
}