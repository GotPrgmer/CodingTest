import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int X;
    static List<Pair1238>[] graph;
    static int[] dist;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[from].add(new Pair1238(to, w));
        }
        ans = new int[N+1];
        djkstra(X);
        ans = dist;
        for(int i=1;i<N+1;i++){
            if(i!=X){
                djkstra(i);
                ans[i]+=dist[X];
            }
        }
        int max = -1;
        for(int i=1;i<N+1;i++){
            if (max < ans[i]) {
                max = ans[i];
            }
        }
        System.out.println(max);

    }
    private static void djkstra(int start){
        PriorityQueue<Pair1238> pq = new PriorityQueue<>();
        pq.add(new Pair1238(start, 0));
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while(!pq.isEmpty()){
            Pair1238 cur = pq.poll();
            int curNode = cur.node;
            int curW = cur.w;
            if(dist[curNode] != curW) continue;
            for (Pair1238 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                int nxtW = nxt.w;
                if(dist[nxtNode] <= dist[curNode]+nxtW) continue;
                dist[nxtNode] = dist[curNode]+nxtW;
                pq.add(new Pair1238(nxtNode, dist[nxtNode]));
            }
        }
    }
    private static class Pair1238 implements Comparable<Pair1238>{
        int node;
        int w;
        @Override
        public int compareTo(Pair1238 p){
            return Integer.compare(this.w, p.w);
        }
        Pair1238(int node, int w){
            this.node = node;
            this.w = w;
        }
    }
}
