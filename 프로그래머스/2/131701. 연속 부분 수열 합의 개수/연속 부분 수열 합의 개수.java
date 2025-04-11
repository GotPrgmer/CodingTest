import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> visited = new HashSet<>();
        for(int l=1;l<elements.length+1;l++){
            for(int i=0;i<elements.length;i++){
                int cnt = 1;
                int cur_idx = i;
                int cur = elements[i];
                while(cnt < l){
                    cur_idx += 1;
                    if(cur_idx == elements.length){
                        cur_idx = 0;
                    }
                    cnt += 1;
                    cur += elements[cur_idx];
                }
                visited.add(cur);
                
            }
        }
        // System.out.println(visited);
        return visited.size();
    }
}