import java.util.*;
class Solution {
    static List<List<int[]>> graph;
    public int solution(int N, int[][] road, int K) {
        
        graph = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        //그래프 초기화
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int t = road[i][2];
            graph.get(a).add(new int[]{b,t});
            graph.get(b).add(new int[]{a,t});
            // System.out.println(graph.get(a));
        }
        //다익스트라
        int[] distance = dijkstra(1,N);
        // System.out.println(Arrays.toString(distance));
        int answer = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]<=K){
                answer += 1;
            }
        }
        return answer;
    }
    
    public int[] dijkstra(int start,int N){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0]-i2[0];
            }
        });
        int[] distance = new int[N+1];
        for(int i=1;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        Set<Integer> visited = new HashSet<>();
        distance[1] = 0;
        pq.add(new int[]{0,start});
        while(visited.size()!=N && pq.size()!=0){
            int[] cur = pq.poll();
            int cur_node = cur[1];
            int cur_time = cur[0];
            // System.out.println(cur_node);
            if(visited.contains(cur_node)){
                continue;
            }
            visited.add(cur_node);
            //갱신
            for(int[] i:graph.get(cur_node)){
                // System.out.println(i[0]);
                if(distance[i[0]] > cur_time + i[1] && !visited.contains(i[0])){
                    // visited.add(i[0]);
                    distance[i[0]] = cur_time + i[1];
                    pq.add(new int[]{distance[i[0]],i[0]});
                }
            }
            
        }
        return distance;
    }
}