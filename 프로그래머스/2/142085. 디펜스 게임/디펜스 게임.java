import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int round = Math.min(k,enemy.length);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<enemy.length;i++){
            pq.add(enemy[i]);
            if(i<k){
                continue;
            }
            else{
                if(n>=pq.peek()){
                    // System.out.println(pq.peek());
                    n -= pq.poll();
                    round += 1;
                }
                else{
                    // System.out.println(i);
                    break;
                }
            }
        }
        return round;
    }
}