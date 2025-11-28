import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static List<Pair24042>[] graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE / 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair24042(b, i));
            graph[b].add(new Pair24042(a, i));
        }
        System.out.println(djkstra());
    }
    private static long djkstra(){
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        PriorityQueue<Pair24042> pq = new PriorityQueue<>();
        pq.add(new Pair24042(1, 0));
        while (!pq.isEmpty()) {
            Pair24042 cur = pq.poll();
            int curNode = cur.node;
            long curW = cur.wait;
            if(dist[curNode] != curW) continue;

            long curIdx = curW % (long) M;
            for (Pair24042 nxt : graph[curNode]) {
                int nxtNode = nxt.node;
                int nxtIdx = nxt.idx;

                long wait = (long) nxtIdx - curIdx;
                if(wait < 0) wait += (long) M;

                long nxtW = curW + wait +1;
                if(dist[nxtNode] <= nxtW) continue;
                dist[nxtNode] = nxtW;
                pq.add(new Pair24042(nxtNode, nxtW));
            }
        }
        return dist[N];
    }

    private static class Pair24042 implements Comparable<Pair24042> {
        int node;
        int idx;
        long wait;
        Pair24042(int node, long wait){
            this.node = node;
            this.wait = wait;
        }

        Pair24042(int node, int idx){
            this.node = node;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair24042 p){
            return Long.compare(this.wait, p.wait);
        }
    }
}
