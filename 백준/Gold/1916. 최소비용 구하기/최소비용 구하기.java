import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;
    static List<Pair1916>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair1916(b,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(djkstra(start, end));


    }
    private static int djkstra(int start, int end){
        PriorityQueue<Pair1916> pq = new PriorityQueue<>();
        pq.add(new Pair1916(start, 0));
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while(!pq.isEmpty()){
            Pair1916 cur = pq.poll();
            int curNode = cur.node;
            int curW = cur.w;
            if(dist[curNode] != curW) continue;
            for (Pair1916 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                int nxtW = nxt.w;
                if(dist[nxtNode] <= dist[curNode]+nxtW) continue;
                dist[nxtNode] = dist[curNode] + nxtW;
                pq.add(new Pair1916(nxtNode, dist[nxtNode]));
            }
        }
        return dist[end];
    }
    private static class Pair1916 implements Comparable<Pair1916>{
        int node;
        int w;
        Pair1916(int node, int w){
            this.node = node;
            this.w = w;
        }
        @Override
        public int compareTo(Pair1916 p){
            return Integer.compare(this.w, p.w);
        }
    }
}
