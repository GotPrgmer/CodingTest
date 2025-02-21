import java.util.*;
class Solution {
    static List<Node>[] list;
    public int solution(int N, int[][] road, int K) {
        //좌표
        list = new ArrayList[N+1];
        int answer = 0;
        //다익스트라
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        //그래프 정보 넣기
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        //다익스트라 돌리기
        int[] values = dijkstra(1,N);
        for(int i=1;i<values.length;i++){
            if(values[i]<=K){
                answer += 1;
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(Arrays.toString(values));

        return answer;
    }
    public int[] dijkstra(int i,int n){
        boolean[] visited = new boolean[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        System.out.println(Arrays.toString(dp));
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1,0));
        // visited[i] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(visited[cur.to]) continue;
            else visited[cur.to]=true;
            dp[cur.to] = cur.cost;
            for(Node next:list[cur.to]){
                if(dp[next.to] >= next.cost+dp[cur.to]){
                    q.add(new Node(next.to,next.cost+dp[cur.to]));
                    // visited[next.to] = true;
                }
            }
            
        }
        return dp;
    }
    public class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to,int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        } 
    }
}