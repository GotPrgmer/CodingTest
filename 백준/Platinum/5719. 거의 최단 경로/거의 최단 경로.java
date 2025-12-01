import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<Pair5719>[] graph;
    static int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N];
            for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                graph[U].add(new Pair5719(V, P));
            }
            sb.append(djkstra(S, D)).append("\n");
        }
        System.out.println(sb);
    }
    private static int djkstra(int S, int D){
        Set<Integer>[] prev = new HashSet[N];
        for(int i=0;i<N;i++) prev[i] = new HashSet<>();

        PriorityQueue<Pair5719> pq = new PriorityQueue<>();
        pq.add(new Pair5719(S, 0));

        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[S] = 0;

        //첫번째 다익스트라
        while(!pq.isEmpty()){
            Pair5719 cur = pq.poll();
            int curNode = cur.node;
            int curWeight = cur.weight;

            if(dist[curNode] != curWeight) continue;

            for (Pair5719 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                int nxtWeight = nxt.weight;

                if (dist[curNode] + nxtWeight < dist[nxtNode]) {
                    dist[nxtNode] = dist[curNode] + nxtWeight;
                    prev[nxtNode].clear();
                    prev[nxtNode].add(curNode);
                    pq.add(new Pair5719(nxtNode, dist[nxtNode]));
                } else if (dist[curNode] + nxtWeight == dist[nxtNode]) {
                    prev[nxtNode].add(curNode);
                }
            }
        }

        if (dist[D] == INF) return -1;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(D);
        visited[D] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : prev[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.add(u);
                }
                // u -> v 로 가는 간선 중, dist1[u] + w == dist1[v] 를 만족하는 것만 제거
                for (Pair5719 e : graph[u]) {
                    if (e.node == v && dist[u] != INF && dist[u] + e.weight == dist[v]) {
                        e.removed = true;
                    }
                }

            }
        }

        // 3) 두 번째 다익스트라: removed 간선을 제외하고 최단거리
        int[] dist2 = new int[N];
        Arrays.fill(dist2, INF);
        dist2[S] = 0;

        pq = new PriorityQueue<>();
        pq.add(new Pair5719(S, 0));

        while (!pq.isEmpty()) {
            Pair5719 cur = pq.poll();
            int curNode = cur.node;
            int curWeight = cur.weight;
            if (dist2[curNode] != curWeight) continue;

            for (Pair5719 e : graph[curNode]) {
                if (e.removed) continue; // ★ 최단경로 간선 제거
                int nxtNode = e.node;
                int nd = dist2[curNode] + e.weight;
                if (nd >= dist2[nxtNode]) continue;
                dist2[nxtNode] = nd;
                pq.add(new Pair5719(nxtNode, nd));
            }
        }

        return (dist2[D] == INF) ? -1 : dist2[D];
    }

    static private class Pair5719 implements Comparable<Pair5719> {
        int node;
        int weight;
        boolean removed;
        Pair5719(int node, int weight){
            this.node = node;
            this.weight = weight;
            this.removed = false;
        }
        @Override
        public int compareTo(Pair5719 p){
            return Integer.compare(this.weight, p.weight);
        }
    }
}
