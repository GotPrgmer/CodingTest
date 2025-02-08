import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        for(int r=1;r<board.length;r++){
            for(int c=1;c<board[0].length;c++){
                if(board[r][c] == 1){
                    board[r][c] = Math.min(board[r-1][c-1],Math.min(board[r-1][c],board[r][c-1]))+1;

                }
            }
        }
        int ans = 0;
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                ans = Math.max(ans,board[r][c]*board[r][c]);
            }
        }


        return ans;
    }
}