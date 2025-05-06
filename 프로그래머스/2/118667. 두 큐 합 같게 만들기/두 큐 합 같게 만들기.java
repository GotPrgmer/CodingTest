import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum_q1 = 0;
        long sum_q2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0 ; i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            sum_q1 += queue1[i];
            sum_q2 += queue2[i];
        }
        long half = (sum_q1+sum_q2)/2;
        int cnt = 0;
        if(sum_q1<half && sum_q2<half){
            return -1;
        }
        while(sum_q1!=sum_q2 && cnt <=queue1.length + queue2.length+1){
            if(half <sum_q1 && !q1.isEmpty()){
                int cur = q1.poll();
                q2.add(cur);
                sum_q1 -= cur;
                sum_q2 += cur;
                cnt += 1;
            }
            else if(half < sum_q2 && !q2.isEmpty()){
                int cur = q2.poll();
                q1.add(cur);
                sum_q1 += cur;
                sum_q2 -= cur;
                cnt += 1;
            }
            
        }
        if(sum_q1 == sum_q2){
            return cnt;
        }
        else{
            return -1;
        }

    }
}