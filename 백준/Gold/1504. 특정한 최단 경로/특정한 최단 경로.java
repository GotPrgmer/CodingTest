import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int E;
    static List<Pair1504>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair1504(b, w));
            graph[b].add(new Pair1504(a, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        // 1 to v1
        // v1 to v2
        // v2 to N;
        //혹은
        // 1 to v2
        // v2 to v1
        // v1 to N;

        int v1Min = 0;
        int v2Min = 0;
        djkstra(1);
        int a1 = dist[v1];
        int a2 = dist[v2];
        djkstra(v1);
        int b1= dist[v2];
        int b2 = dist[N];
        djkstra(v2);
        int c1 = dist[N];
        int c2 = dist[v1];
        if((a1 == Integer.MAX_VALUE || b1 == Integer.MAX_VALUE || c1 == Integer.MAX_VALUE) && (a2 == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE)){
            System.out.println(-1);
        }
        else if(a1 == Integer.MAX_VALUE || b1 == Integer.MAX_VALUE || c1 == Integer.MAX_VALUE){
            System.out.println(a2+b2+c2);
        }
        else if(a2 == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE){
            System.out.println(a1+b1+c1);
        }
        else{
            System.out.println(Math.min(a1+b1+c1,a2+b2+c2));
        }

        // a가 존재하지 않거나 a'가 존재하지 않으면 -1을 출력한다.
        // v1 to v2로 못 갈 수도 있음.

    }
    private static void djkstra(int start){
        PriorityQueue<Pair1504> pq = new PriorityQueue<>();
        pq.add(new Pair1504(start, 0));
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair1504 cur = pq.poll();
            int curNode = cur.node;
            int curW = cur.w;
            if(dist[curNode] != curW) continue;
            for (Pair1504 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                int nxtW = nxt.w;
                if(dist[nxtNode] <= dist[curNode]+nxtW) continue;
                dist[nxtNode] = dist[curNode] + nxtW;
                pq.add(new Pair1504(nxtNode, dist[nxtNode]));
            }
        }
    }
    private static class Pair1504 implements Comparable<Pair1504>{
        int node;
        int w;
        Pair1504(int node, int w){
            this.node = node;
            this.w = w;
        }
        @Override
        public int compareTo(Pair1504 p){
            return Integer.compare(this.w, p.w);
        }
    }
}