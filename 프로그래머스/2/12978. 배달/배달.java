import java.util.*;
class Solution {
    static List<List<Node>> graph; 
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b= road[i][1];
            int t= road[i][2];
            graph.get(a).add(new Node(b,t));
            graph.get(b).add(new Node(a,t));
        }
        // System.out.println(Arrays.toString(dijkstra(1,N)));
        int[] distance = dijkstra(1,N);
        int answer = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]<=K){
                answer += 1;
            }
        }
        
        return answer;
    }
    public int[] dijkstra(int start,int N){
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        for(int i=0;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1,int[] i2){
                return i1[0] - i2[0];
            }
        });
        distance[start] = 0;
        pq.add(new int[]{0,start});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_time = cur[0];
            int cur_node = cur[1];
            if(visited[cur_node]){
                continue;
            }
            visited[cur_node] = true;
            //현재 연결된 노드에서 주변 노드 업데이트 시키고
            //업데이트 된 노드 pq에 추가
            for(Node node:graph.get(cur_node)){
                if(!visited[node.to] && distance[node.to]>cur_time+node.time){
                    distance[node.to] = cur_time+node.time;
                    pq.add(new int[]{distance[node.to],node.to});
                }
            }
        }
        return distance;
        
    }
}

class Node{
    int to;
    int time;
    public Node(int to,int time){
        this.to = to;
        this.time = time;
    }
}