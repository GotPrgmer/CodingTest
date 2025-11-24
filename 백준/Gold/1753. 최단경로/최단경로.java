import java.util.*;
import java.io.*;
public class Main {
    static int V;
    static int E;
    static int K;
    static List<Pair1753>[] graph;
    static int[] dist; // 테이블
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=0;i<V+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair1753(v, w));
        }
        djkstra();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<V+1;i++){
            if(dist[i] != Integer.MAX_VALUE){
                sb.append(dist[i]).append("\n");
            }
            else{
                sb.append("INF").append("\n");
            }
        }
        System.out.println(sb);

    }
    private static void djkstra(){
        PriorityQueue<Pair1753> pq = new PriorityQueue<>(new Comparator<Pair1753>() {
            @Override
            public int compare(Pair1753 p1, Pair1753 p2){
            return p1.w - p2.w;
        }
        });
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        pq.add(new Pair1753(K, 0));
        while(!pq.isEmpty()){
            Pair1753 cur = pq.poll();
            int curTo = cur.to;
            int curW = cur.w;
            //테이블 확인
            if(dist[curTo] != curW) continue;
            //해당 정점에서 이어진 정점까지의 거리를 테이블에 갱신
            //갱신이 되면 힙에 넣고 그렇지 않으면 통과
            for(Pair1753 nxt:graph[curTo]){
                int nxtNode = nxt.to;
                int nxtW = nxt.w;
                if(dist[nxtNode] <= curW+nxtW) continue;
                dist[nxtNode] = curW+nxtW;
                pq.add(new Pair1753(nxtNode, dist[nxtNode]));
            }
        }
    }

    private static class Pair1753{
        int to;
        int w;
        Pair1753(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
}
