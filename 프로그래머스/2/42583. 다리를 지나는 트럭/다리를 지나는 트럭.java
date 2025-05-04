import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> on_bridge = new LinkedList<>();
        int time = 0;
        int sum = 0;
        for(int i=0;i<truck_weights.length;i++){
            int cur = truck_weights[i];
            while(true){
                //큐가 비어있을 경우 추가
                if(on_bridge.isEmpty()){
                    on_bridge.add(cur);
                    time += 1;
                    sum += cur;
                    break;
                }
                //큐가 가득차지않을 경우 더 넣을 수 있는 지 확인
                else if(on_bridge.size() < bridge_length){
                    if(sum + cur<=weight){
                        on_bridge.add(cur);
                        time += 1;
                        sum += cur;
                        break;
                    }
                    else{
                        on_bridge.add(0);
                        time += 1;
                    }
                }
                else if(on_bridge.size() == bridge_length){
                    sum -= on_bridge.poll();
                }
            }
        }

        
        
        return time+bridge_length;
    }
}