import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        while(n!=0){
            int cur = pq.poll();
            if(cur==0) break;
            cur -= 1;
            pq.add(cur);
            n -= 1;
        }
        if(pq.isEmpty()){
            return 0;
        }
        long ans = 0;
        while(!pq.isEmpty()){
            int night = pq.poll();
            ans += (long)night*night;
        }
        return ans;
    }
}