import java.util.*;
import java.io.*;
public class Main {
    static PriorityQueue<Long>[] dist;
    static List<Pair1854>[] graph;
    static int n, m ,k;
    static long INF = Long.MAX_VALUE / 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair1854(b, w));
        }
        djkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) sb.append(-1).append('\n');
            else sb.append(dist[i].peek()).append('\n'); // max-heap의 top == k번째 최단거리
        }
        System.out.print(sb);
    }
    static private int djkstra(){
        PriorityQueue<Pair1854> pq = new PriorityQueue<>();
        dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) dist[i] = new PriorityQueue<>(Collections.reverseOrder()); // max-heap

        dist[1].add(0L);
        pq.add(new Pair1854(1, 0));
        while(!pq.isEmpty()){
            Pair1854 cur = pq.poll();
            int curNode = cur.node;
            long curWeight = cur.weight;

            if (dist[curNode].size() == k && dist[curNode].peek() < curWeight) continue;
            for (Pair1854 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                long nd = curWeight + nxt.weight;

                if (dist[nxtNode].size() < k) {
                    dist[nxtNode].add(nd);
                    pq.add(new Pair1854(nxtNode, nd));
                } else if (dist[nxtNode].peek() > nd) {
                    dist[nxtNode].poll();    // 현재 k개 중 가장 큰 값(=k번째)을 제거
                    dist[nxtNode].add(nd);
                    pq.add(new Pair1854(nxtNode, nd));
                }
            }
        }
//        System.out.println(Arrays.toString(cnt));
//        System.out.println(Arrays.toString(dist));
        return 0;
    }
    static private class Pair1854 implements Comparable<Pair1854>{
        int node;
        long weight;
        Pair1854(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair1854 p){
            return Long.compare(this.weight, p.weight);
        }
    }
}
