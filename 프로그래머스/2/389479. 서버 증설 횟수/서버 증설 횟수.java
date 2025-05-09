import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[players.length];
        
        for(int i=0;i<players.length;i++){
            int cur_player_cnt = players[i];
            
            if(cur_player_cnt/m <= server[i]) continue;
                
            for(int j=1;j<k && (i+j)<players.length;j++){
                server[i+j] += cur_player_cnt/m - server[i];
            }
            answer += cur_player_cnt/m - server[i];
        }
        
        return answer;
    }
}