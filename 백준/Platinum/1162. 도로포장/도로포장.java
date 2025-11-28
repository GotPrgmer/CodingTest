import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int K;
    static long INF = Long.MAX_VALUE/4;
    static List<Pair1162>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            graph[a].add(new Pair1162(b, w));
            graph[b].add(new Pair1162(a, w));
        }

        System.out.println(djkstra());

    }
    private static long djkstra(){
        PriorityQueue<Pair1162> pq = new PriorityQueue<>();
        pq.add(new Pair1162(1, 0, 0));

        long[][] dist = new long[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) Arrays.fill(dist[i], INF);
        dist[1][0] = 0;
        while(!pq.isEmpty()){
            Pair1162 cur = pq.poll();
            int curNode = cur.node;
            long curW = cur.w;
            int curK = cur.k;
            if(dist[curNode][curK] != curW) continue;
            for (Pair1162 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                long nxtWeight = nxt.w;
                if(dist[nxtNode][curK] > dist[curNode][curK]+nxtWeight){
                    dist[nxtNode][curK] = dist[curNode][curK]+nxtWeight;
                    pq.add(new Pair1162(nxtNode, dist[nxtNode][curK], curK));
                }
                if(curK+1<=K && dist[nxtNode][curK+1] > dist[curNode][curK]+0){
                    dist[nxtNode][curK+1] = dist[curNode][curK]+0;
                    pq.add(new Pair1162(nxtNode, dist[nxtNode][curK+1], curK+1));
                }
            }
        }
        long ans = INF;
        for(int i=0;i<K+1;i++){
            if(ans > dist[N][i]){
                ans = dist[N][i];
            }
        }
        return ans;
    }


    private static class Pair1162 implements Comparable<Pair1162> {
        int node;
        long w;
        int k;
        Pair1162(int node, long w, int k){
            this.node = node;
            this.w = w;
            this.k = k;
        }
        Pair1162(int node, long w){
            this.node = node;
            this.w = w;
        }
        @Override
        public int compareTo(Pair1162 p){
            return Long.compare(this.w, p.w);
        }
    }
}