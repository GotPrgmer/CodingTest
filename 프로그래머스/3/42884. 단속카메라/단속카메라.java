import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<routes.length;i++){
            pq.add(routes[i]);
        }
        int[] first_car = pq.poll();
        int cctv_loc = first_car[1];
        int cnt = 1;
        for(int i=1;i<routes.length;i++){
            int[] cur = pq.poll();
            if(cctv_loc > cur[1]){
                cctv_loc = cur[1];
            }
            else if(cctv_loc < cur[0]){
                cnt += 1;
                cctv_loc = cur[1];
            }
        }
        return cnt;
    }
}