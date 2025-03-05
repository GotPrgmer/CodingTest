import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int tmp = 100-progresses[i];
            int value = tmp/speeds[i];
            value += tmp%speeds[i] == 0? 0:1;
            if(pq.size()==0){
                pq.offer(-value);
            }
            else{
                //stack top보다 크면 그렇지 않을때까지 전부 pop, pop한 숫자를 넣어야함.
                //다 Pop했으면 지금 value값 넣어야함.
                int cnt = 0;
                System.out.println(pq);
                while(pq.size()!=0 && -pq.peek()<value){
                    pq.poll();
                    cnt += 1;
                }
                if(cnt>0){
                    list.add(cnt);
                }
                pq.offer(-value);
            }
        }
        if(pq.size()!=0){
            list.add(pq.size());
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}