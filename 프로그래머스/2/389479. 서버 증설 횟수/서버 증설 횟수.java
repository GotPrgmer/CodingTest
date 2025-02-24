import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        int answer = 0;
        int size = 0;
        for(int i=0;i<24;i++){
            //일단 뺄 수 있는 서버들 다 빼야함
            while(!q.isEmpty() && q.peek()[0]==i){
                int minusServer = q.poll()[1];
                size -= minusServer;
            }
            //더 필요한 서버가 잇는지 체크
            int need = players[i]/m;
            int more = size-need;
            if(more <0){
                more = - more;
                answer += more;
                q.add(new int[]{i+k,more});
                size += more;
            }
        }
        return answer;
    }
}