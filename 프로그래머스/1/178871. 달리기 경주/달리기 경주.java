import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        // callings에서 하나씩 빼서 순위를 변경
        for(String p:callings){
            int tmp = map.get(p);
            map.put(p,tmp-1);
            String prevPlayer = players[tmp-1];
            map.put(prevPlayer,tmp);
            players[tmp-1] = p;
            players[tmp] = prevPlayer;
        }
        
        return players;
    }
}